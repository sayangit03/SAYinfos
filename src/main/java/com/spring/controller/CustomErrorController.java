package com.spring.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class CustomErrorController implements ErrorController {
	
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, ModelMap modelMap) {
        //do something like logging
    	Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
    	String errorStatusCode = null;
    	String reqURI = null;
    	if (status != null) {
    		errorStatusCode = status.toString();
    		reqURI = (String) request.getAttribute("reqURI1");
    	}
    	modelMap.addAttribute("errorStatusCode", errorStatusCode);
    	modelMap.addAttribute("reqURI", reqURI);
        return "error";
    }
 
    @Override
    public String getErrorPath() {
        return "/error";
    }

}
