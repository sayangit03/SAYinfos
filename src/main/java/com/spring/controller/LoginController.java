package com.spring.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.beans.Contribution;
import com.spring.beans.User;
import com.spring.beans.UserDetails;
import com.spring.beans.UserLogin;
import com.spring.beans.UserRegDetails;
import com.spring.service.LoginService;

@Controller
@SessionAttributes("user")
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value = "/mylogin")
	public String performLogin(ModelMap modelMap, UserLogin user, RedirectAttributes redirectAtt,HttpSession session, HttpServletRequest req) {
		System.out.println("Logging in user with unique name: "+user.getUniqueName()+" | "+session.getAttribute("uNm"));
		if(session.getAttribute("uNm")!=null && session.getAttribute("pWd")!=null) {
			if(user.getUniqueName()==null && user.getUserPwd()==null) {
				user.setUniqueName(session.getAttribute("uNm").toString());
				user.setUserPwd(session.getAttribute("pWd").toString());
			}
		}
		boolean isOkToLoginFlag = loginService.doLogin(user);
		
		String userFullName = null;
		String userRole = null;
		String userLoc = null;
		String userEml = null;
		String userPhn = null;
		
		List<UserDetails> usrLoginDetails = loginService.getAllApprovedUserDetails();
		List<UserRegDetails> usrRegDetails = loginService.getAllRegUserDetails();
		for(UserRegDetails rUsr : usrRegDetails) {
			for(UserDetails lUsr : usrLoginDetails) {
				if(rUsr.getUserEmail().equals(lUsr.getUserEmail())) {
					rUsr.setUserRole(lUsr.getLogin().getUserRole());
				}
				if(lUsr.getLogin().getUniqueName().equals(user.getUniqueName())) {
					userFullName = lUsr.getLogin().getUserName();
					userRole = lUsr.getLogin().getUserRole();
					userLoc = lUsr.getUserAdrs();
					userEml = lUsr.getUserEmail();
					userPhn = lUsr.getUserPhnNum();
				}
			}
		}
		
		List<Contribution> contriList = loginService.getContributions(userEml);
		if(contriList!=null && contriList.size()>0) {
			for(int i=0; i<contriList.size(); i++) {
				contriList.get(i).setId(i+1);
			}
		}
		
		List<Contribution> flashUserList =  loginService.getByFlashUserUniqueName();
		
		
		if(userFullName!=null && userRole!=null) {
			modelMap.addAttribute("usrFullName", userFullName.substring(0, userFullName.indexOf(' ')));
			modelMap.addAttribute("usrFullNameTbl", userFullName);
			modelMap.addAttribute("userRole", userRole);
			modelMap.addAttribute("userLoc", userLoc);
			modelMap.addAttribute("userEml", userEml);
			modelMap.addAttribute("userPhn", userPhn);
			modelMap.addAttribute("usrRegDetails", usrRegDetails);
			modelMap.addAttribute("contriList", contriList);
			modelMap.addAttribute("flashUserList", flashUserList);
			
			
			session.setAttribute("uNm", user.getUniqueName());
			session.setAttribute("pWd", user.getUserPwd());
			session.setAttribute("usrFullName", userFullName.substring(0, userFullName.indexOf(' ')));
			session.setAttribute("usrFullNameTbl", userFullName);
			session.setAttribute("userRole", userRole);
			session.setAttribute("userEml", userEml);
			session.setAttribute("flashUser", false);
		}
		System.out.println("User Name: "+userFullName+" | User Role: "+userRole);
		if(isOkToLoginFlag && userRole.equals("Admin")) {
			System.out.println("oktologin unique name: "+user.getUniqueName());
			return "home_all";
		}
		else if(isOkToLoginFlag && userRole.equals("User")) {
			return "home_user";
		}
		redirectAtt.addFlashAttribute("loginFlag", 0);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/ssoLogin")
	public String ssoLogin(OAuth2Authentication authentication, Principal principal, HttpSession session, ModelMap modelMap) {
		LinkedHashMap<String, Object> properties = (LinkedHashMap<String, Object>) authentication.getUserAuthentication().getDetails();
        
        System.out.println((String) properties.get("name"));
        System.out.println((String) properties.get("email"));
        System.out.println(authentication.getUserAuthentication().getAuthorities().toString());
        
        List<Contribution> contriList = loginService.getContributions(properties.get("email").toString());
		if(contriList!=null && contriList.size()>0) {
			for(int i=0; i<contriList.size(); i++) {
				contriList.get(i).setId(i+1);
			}
		}
		
        String userFullName = properties.get("name").toString();
        session.setAttribute("usrFullName", userFullName.substring(0, userFullName.indexOf(' ')));
        session.setAttribute("uNm", "flash-"+properties.get("email").toString().substring(0, properties.get("email").toString().indexOf('@')));
        session.setAttribute("usrFullNameTbl", properties.get("name").toString());
		session.setAttribute("userRole", authentication.getUserAuthentication().getAuthorities().toString().substring(1, authentication.getUserAuthentication().getAuthorities().toString().length()-1));
		session.setAttribute("userEml", properties.get("email").toString());
		session.setAttribute("flashUser", true);
		
		modelMap.addAttribute("usrFullName", userFullName.substring(0, userFullName.indexOf(' ')));
		modelMap.addAttribute("uNm", "flash-"+properties.get("email").toString().substring(0, properties.get("email").toString().indexOf('@')));
		modelMap.addAttribute("usrFullNameTbl", properties.get("name").toString());
		modelMap.addAttribute("userRole", authentication.getUserAuthentication().getAuthorities().toString().substring(1, authentication.getUserAuthentication().getAuthorities().toString().length()-1));
		modelMap.addAttribute("flashUser", true);
		modelMap.addAttribute("contriList", contriList);
		return "home_user";
	}
	
	@RequestMapping(value = "/contribute")
	public String doContribute() {
		System.out.println("In login controller contribute method..");
		
		return "home_user_contribute";
	}
	
	@RequestMapping(value = "/mylogout")
	public String performLogout(HttpSession session, HttpServletResponse res) {
		session.invalidate();
		/*
		 * res.setHeader("Cache-Control", "no-cache"); res.setHeader("Cache-Control",
		 * "no-store"); res.setDateHeader("Expires", 0);
		 */
		return "redirect:/";
	}

}
