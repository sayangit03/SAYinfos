package com.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.beans.Email;
import com.spring.resource.MailService;

@Controller
public class HomeController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	MailService mailService;
	
	private static Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping("/")
	public String home(ModelMap modelMap, HttpServletRequest req, Model model) {
		logger.info("************** Hello from home controller **************");

		if(model.asMap().get("serviceFlag")!=null) {
			modelMap.addAttribute("serviceFlag1", 0);
		}
		else {
			modelMap.addAttribute("serviceFlag1", 1);
		}
		
		if(model.asMap().get("accessFlag")!=null) {
			modelMap.addAttribute("accessFlag1", 0);
		}
		else {
			modelMap.addAttribute("accessFlag1", 1);
		}
		
		if(model.asMap().get("fEmail")!=null) {
			String emailfFlag = model.asMap().get("fEmail").toString();
			if(emailfFlag.equals("notokreg"))
				modelMap.addAttribute("emailfFlag1", 0);
			else
				modelMap.addAttribute("emailfFlag1", 1);
		}
		else
		{
			modelMap.addAttribute("emailfFlag1", 2);
		}

		if(model.asMap().get("loginFlag")!=null) {
			System.out.println("Login failed........");
			modelMap.addAttribute("isOk", 0);
		}
		else {
			modelMap.addAttribute("isOk", 2);
		}

		//modelMap.addAttribute("isOk",1);
		return "index";
	}

	@RequestMapping(value = "/mail", method = RequestMethod.POST)
	public void sendMail(Email email) {

		System.out.println("Sending Mail.. "+ email.getEmail());
		mailService.sendEmail("sayman.eye@gmail.com", email.getSubject(), email.getMessage()+"\n\nName: "+email.getName()+"\n\nEmail Id: "+email.getEmail());
		mailService.sendEmail(email.getEmail(), "Confirmation on Email Reception", "Hi "+email.getName()+", \n\nThanks for your response. We will get back to you after inital review. \n\n\n\n-SAYinfos");
		//return "index";
	}

	@RequestMapping("/birthday")
	public String happyBirthday() {
		return "birthday";
	}

	@RequestMapping(value = "/privacyPolicy")
	public String privacyPolicy() {
		return "privacy_policy";
	}

	@RequestMapping(value = "/closedService")
	public String serviceNotification(RedirectAttributes redirectAtt) {
		redirectAtt.addFlashAttribute("serviceFlag", 0);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/websiteClosed")
	public String serveClosedWebsitePage() {
		return "proxy_home";
	}
	
	@RequestMapping(value = "/unauthorizedAccess")
	public String unauthorizedAccessMsg(RedirectAttributes redirectAtt) {
		redirectAtt.addFlashAttribute("accessFlag", 0);
		return "redirect:/";
	}


	/*
	 * @RequestMapping("/") public String getCovid19Resource(ModelMap mpdelMap) {
	 * HttpHeaders httpHeaders = new HttpHeaders();
	 * httpHeaders.add("x-rapidapi-host",
	 * "andruxnet-random-famous-quotes.p.rapidapi.com");
	 * httpHeaders.add("x-rapidapi-key",
	 * "a2a4c73bc1msh3a3dfe6e97f4466p1f526cjsn8a1541e29763"); String url =
	 * "https://andruxnet-random-famous-quotes.p.rapidapi.com/";
	 * 
	 * HttpEntity<String> req = new HttpEntity<String>(httpHeaders); FamousQuotes[]
	 * quoteArray = restTemplate.exchange(url, HttpMethod.GET, req,
	 * FamousQuotes[].class).getBody(); FamousQuotes quote = new FamousQuotes();
	 * quote = Arrays.asList(quoteArray).get(0);
	 * System.out.println(quote.getQuote());
	 * 
	 * return "index"; }
	 */


}
