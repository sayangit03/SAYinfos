package com.spring.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CustomErrorController implements ErrorController {
	
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, RedirectAttributes redirectAtt) {
        //do something like logging
    	Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
    	String errorStatusCode = null;
    	String reqURI = null;
    	if (status != null) {
    		errorStatusCode = status.toString();
    		reqURI = (String) request.getAttribute("reqURI1");
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
    
    @RequestMapping("/errorOccurred")
    public String returnErrorPage(Model model, ModelMap modelMap) {
    	if(model.asMap().get("errorStatusCode")!=null && model.asMap().get("reqURI")!=null) {
    		 modelMap.addAttribute("errorStatusCode", model.asMap().get("errorStatusCode").toString());
    		 modelMap.addAttribute("reqURI", model.asMap().get("reqURI").toString());
    	}
    	return "error";
    }

}
