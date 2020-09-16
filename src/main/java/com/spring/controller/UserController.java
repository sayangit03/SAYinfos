package com.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.beans.User;
import com.spring.beans.UserLogin;
import com.spring.resource.MailService;
import com.spring.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserController {

	@Autowired
	UserService uServ;

	@Autowired
	MailService mailService;

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String regUser(User user, ModelMap modelMap, HttpServletRequest req, BindingResult br) {
		log.info("Hello from user controller.");
		String flag = null;

		if (user != null)
			flag = uServ.registerUser(user);
		req.setAttribute(user.getEmail(), flag);
		/*
		 * if(br.hasErrors()) { return "index"; }
		 */
		if (flag != null && flag.equals("ok"))
			modelMap.addAttribute("isOkReg", 1);
		else
			modelMap.addAttribute("isOkReg", 0);
		log.info("Hello from user controler | isOkReg " + flag);
		return "redirect:/validateEmailReg/" + flag;
		// return "index";
	}

	@GetMapping(value = "/approveUser/{email}")
	public String approveUser(@ModelAttribute("user") UserLogin user, @PathVariable String email) {
		log.info("Approving as user | login: " + user.getUniqueName() + " | " + email);
		String approvedUnNm = uServ.approveUser(email);
		try {
			mailService.sendEmail(email, "Welcome to SAYinfos",
					"Your request for registration with SAYinfos has been approved. Please use the login name below to login into the portal as user.\n\nLogin Name: "
							+ approvedUnNm + "\n\n\n\n-SAYinfos");
		} catch (Exception e) {
			log.info("User approval mail not sent");
		}
		return "redirect:/mylogin";
	}

	@GetMapping(value = "/approveAdmin/{email}")
	public String approveAdmin(@ModelAttribute("user") UserLogin user, @PathVariable String email) {
		log.info("Approving as admin | login: " + user.getUniqueName() + " | " + email);
		String approvedUnNm = uServ.approveAdmin(email);
		try {
			mailService.sendEmail(email, "Welcome to SAYinfos",
					"Your request for registration with SAYinfos has been approved. Please use the login name below to login into the portal as admin.\n\nLogin Name: "
							+ approvedUnNm + "\n\n\n\n-SAYinfos");
		} catch (Exception e) {
			log.info("Admin approval mail not sent");
		}
		return "redirect:/mylogin";
	}

	@RequestMapping(value = "/validateEmailReg/{isOkRegFlag}", method = RequestMethod.GET)
	public String OK(@PathVariable String isOkRegFlag, HttpServletRequest req, RedirectAttributes redirectAtt) {
		log.info("from ok validation email= " + isOkRegFlag);
		req.getSession().setAttribute("ok", isOkRegFlag);
		redirectAtt.addFlashAttribute("fEmail", isOkRegFlag);
		return "redirect:/";
	}

	@GetMapping(value = "/removeLogin/{email}")
	public String removeLogin(@PathVariable String email) {
		log.info("Removing login for: " + email);
		uServ.removeLogin(email);
		return "redirect:/mylogin";
	}
}
