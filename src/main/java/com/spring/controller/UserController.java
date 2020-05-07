package com.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.beans.User;
import com.spring.beans.UserLogin;
import com.spring.resource.MailService;
import com.spring.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService uServ;
	
	@Autowired
	MailService mailService;
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String regUser(@Valid User user, ModelMap modelMap, HttpServletRequest req, BindingResult br) {
		System.out.println("Hello from user controller.");
		String flag = null;
		
		if(user!=null)
			flag = uServ.registerUser(user);
		req.setAttribute(user.getEmail(), flag);
		/*
		 * if(br.hasErrors()) { return "index"; }
		 */
		if(flag!=null && flag.equals("ok"))
			modelMap.addAttribute("isOkReg",1);
		else
			modelMap.addAttribute("isOkReg",0);
		System.out.println("Hello from user controler | isOkReg "+flag);
		return "redirect:/validateEmailReg/"+flag;
		//return "index";
	}
	
	@GetMapping(value = "/approveUser/{email}")
	public String approveUser(@ModelAttribute("user") UserLogin user, @PathVariable String email) {
		System.out.println("Approving as user | login: "+user.getUniqueName()+" | "+email);
		String approvedUnNm = uServ.approveUser(email);
		try {
			mailService.sendEmail(email, "Welcome to SAYinfos", "Your request for registration with SAYinfos has been approved. Please use the login name below to login into the portal as user.\n\nLogin Name: "+approvedUnNm+"\n\n\n\n-SAYinfos");
		}catch (Exception e) {
			System.out.println("User approval mail not sent");
		}
		return "redirect:/login";
	}
	
	@GetMapping(value = "/approveAdmin/{email}")
	public String approveAdmin(@ModelAttribute("user") UserLogin user, @PathVariable String email) {
		System.out.println("Approving as admin | login: "+user.getUniqueName()+" | "+email);
		String approvedUnNm = uServ.approveAdmin(email);
		try {
			mailService.sendEmail(email, "Welcome to SAYinfos", "Your request for registration with SAYinfos has been approved. Please use the login name below to login into the portal as admin.\n\nLogin Name: "+approvedUnNm+"\n\n\n\n-SAYinfos");
		}catch (Exception e) {
			System.out.println("Admin approval mail not sent");
		}
		return "redirect:/login";
	}
	
	
	@RequestMapping(value = "/validateEmailReg/{isOkRegFlag}", method = RequestMethod.GET)
	public String OK(@PathVariable String isOkRegFlag, HttpServletRequest req, RedirectAttributes redirectAtt) {
		System.out.println("from ok validation email= "+isOkRegFlag);
		req.getSession().setAttribute("ok", isOkRegFlag);
		redirectAtt.addFlashAttribute("fEmail", isOkRegFlag);
		return "redirect:/";
	}
}
