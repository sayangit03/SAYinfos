package com.spring.controller;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.spring.resource.MailService;
import com.spring.service.AllServicesservice;

@Controller
public class CustomErrorController implements ErrorController {
	@Autowired
	MailService mailService;

	@Autowired
	AllServicesservice serv;

	@Value("${mail.toaddress}")
	String toAddress;

	String reqURIGlobal;

	String errorStatusCodeGlobal;

	final String shutDown = "ShutDown";
	
	final String errorURI = "ErrorURI";

	private static Logger logger = LoggerFactory.getLogger(CustomErrorController.class);

	Runnable runnableMailService = new Runnable() {
		@Override
		public void run() {
			mailService.sendEmail(toAddress, "SAYinfos Error Notification", "Hello Admin, \nPlease find the below details of the error occurred."+"\n\nURI requested: "+reqURIGlobal+"\n"+"Error status code: "+errorStatusCodeGlobal+"\n\n\n\n-SAYinfos");
		}
	};

	LoadingCache<String, Integer> errorUriCache = CacheBuilder.newBuilder().maximumSize(10).expireAfterWrite(300, TimeUnit.SECONDS)
			.build(new CacheLoader<String, Integer>(){
				public Integer load(String key) {
					return 0;
				}
			});

	LoadingCache<String, Integer> websiteShutdownTrackerCache = CacheBuilder.newBuilder().maximumSize(10).expireAfterWrite(300, TimeUnit.SECONDS)
			.build(new CacheLoader<String, Integer>(){
				public Integer load(String key) {
					return 0;
				}
			});

	@RequestMapping("/error")
	public String handleError(HttpServletRequest request, RedirectAttributes redirectAtt) {
		//System.out.println(request.getAttribute(RequestDispatcher.ERROR_MESSAGE));
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		String errorStatusCode = null;
		String reqURI = null;
		if (status != null) {
			errorStatusCode = status.toString();
			reqURI = (String) request.getAttribute("reqURI1");
		}
		reqURIGlobal = reqURI;
		errorStatusCodeGlobal = errorStatusCode;
		if(!(reqURI.contains("/websiteClosed") || reqURI.contains("/generateOTP") || reqURI.contains("/mail"))) {
			Date date = new Date();
			errorUriCache.put(reqURI+"@"+date, 1);
			logger.info("Error Controller: URI cache size increased, new size: "+errorUriCache.size());
		}

		new Thread(runnableMailService).start();

		if(errorUriCache.size()>4) {
			logger.info("Error Controller: Shutting down SAYinfos.. Cache size: "+errorUriCache.size());
			errorUriCache.invalidateAll();
			serv.stopService(15);
			websiteShutdownTrackerCache.put(shutDown, 1);
		}
		/*
		 * modelMap.addAttribute("errorStatusCode", errorStatusCode);
		 * modelMap.addAttribute("reqURI", reqURI);
		 */
		redirectAtt.addFlashAttribute("errorStatusCode", errorStatusCode);
		redirectAtt.addFlashAttribute("reqURI", reqURI);
		return "redirect:/errorOccurred";
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}

	@Scheduled(fixedDelay = 300000)
	public void scheduleFixedDelayTask() {
		if(errorUriCache.size()>0) {
			logger.info("Scheduled Job: Clearing cache. Size: "+errorUriCache.size());
			errorUriCache.invalidateAll();
		}
	}

	@Scheduled(fixedRate = 1000)
	public void scheduledFixedRate() {
		if(websiteShutdownTrackerCache.size()>0){
			logger.info("SAYinfos startup service initiated. Going to sleep for 10 minutes..");
			try {
				Thread.sleep(600000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			serv.startService(15);
			websiteShutdownTrackerCache.invalidateAll();
			logger.info("SAYinfos startup service completed successfully..");
		}
	}

	@RequestMapping("/errorOccurred")
	public String returnErrorPage(Model model, ModelMap modelMap) {
		if(model.asMap().get("errorStatusCode")!=null && model.asMap().get("reqURI")!=null) {
			modelMap.addAttribute("errorStatusCode", model.asMap().get("errorStatusCode").toString());
			modelMap.addAttribute("reqURI", model.asMap().get("reqURI").toString());
		}
		return "error";
	}

}
