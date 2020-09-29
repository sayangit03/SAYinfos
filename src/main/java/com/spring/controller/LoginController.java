package com.spring.controller;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.spring.beans.Contribution;
import com.spring.beans.FlashUser;
import com.spring.beans.UserDetails;
import com.spring.beans.UserLogin;
import com.spring.beans.UserRegDetails;
import com.spring.resource.MailService;
import com.spring.service.LoginService;

import lombok.extern.slf4j.Slf4j;

@Controller
@SessionAttributes("user")
@Slf4j
public class LoginController {

	@Autowired
	LoginService loginService;

	@Autowired
	MailService mailService;

	private String otpEmailIdGlobal;

	LoadingCache<String, Integer> otpCache = CacheBuilder.newBuilder().maximumSize(100)
			.expireAfterWrite(90, TimeUnit.SECONDS).build(new CacheLoader<String, Integer>() {
				public Integer load(String key) {
					return 0;
				}
			});

	private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(value = "/mylogin")
	public String performLogin(ModelMap modelMap, UserLogin user, RedirectAttributes redirectAtt, HttpSession session,
			HttpServletRequest req) {
		LOG.info("Logging in user with unique name: " + user.getUniqueName() + " | " + session.getAttribute("uNm"));
		if (session.getAttribute("uNm") != null && session.getAttribute("pWd") != null) {
			if (user.getUniqueName() == null && user.getUserPwd() == null) {
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
		if (usrLoginDetails != null && usrRegDetails != null) {
			for (UserRegDetails rUsr : usrRegDetails) {
				for (UserDetails lUsr : usrLoginDetails) {
					if (rUsr.getUserEmail().equals(lUsr.getUserEmail())) {
						rUsr.setUserRole(lUsr.getLogin().getUserRole());
					}
					if (lUsr.getLogin().getUniqueName().equals(user.getUniqueName())) {
						userFullName = lUsr.getLogin().getUserName();
						userRole = lUsr.getLogin().getUserRole();
						userLoc = lUsr.getUserAdrs();
						userEml = lUsr.getUserEmail();
						userPhn = lUsr.getUserPhnNum();
					}
				}
			}
		} else {
			log.info("Fallback method called. User lists are null.");
			log.info("Redirecting to home page..");
			redirectAtt.addFlashAttribute("serviceFlag", 0);
			return "redirect:/";
		}
		List<Contribution> contriList = loginService.getContributions(userEml);
		if (contriList != null && contriList.size() > 0) {
			for (int i = 0; i < contriList.size(); i++) {
				contriList.get(i).setId(i + 1);
			}
		}

		List<FlashUser> flashUserList = loginService.getByFlashUserUniqueName();

		if (userFullName != null && userRole != null) {
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
			session.setAttribute("flashUser", true);
		}
		LOG.info("User Name: " + userFullName + " | User Role: " + userRole);
		if (isOkToLoginFlag && userRole.equals("Admin")) {
			LOG.info("oktologin unique name: " + user.getUniqueName());
			return "home_all";
		} else if (isOkToLoginFlag && userRole.equals("User")) {
			return "home_user";
		}
		redirectAtt.addFlashAttribute("loginFlag", 0);
		return "redirect:/";
	}

	@RequestMapping(value = "/ssoLogin")
	public String ssoLogin(OAuth2Authentication authentication, Principal principal, HttpSession session,
			ModelMap modelMap) {
		LinkedHashMap<String, Object> properties = (LinkedHashMap<String, Object>) authentication
				.getUserAuthentication().getDetails();

		LOG.info((String) properties.get("name"));
		LOG.info((String) properties.get("email"));
		LOG.info(authentication.getUserAuthentication().getAuthorities().toString());

		List<Contribution> contriList = loginService.getContributions(properties.get("email").toString());
		if (contriList != null && contriList.size() > 0) {
			for (int i = 0; i < contriList.size(); i++) {
				contriList.get(i).setId(i + 1);
			}
		}

		String userFullName = properties.get("name").toString();
		// session.setAttribute("usrFullName", userFullName.substring(0,
		// userFullName.indexOf(' ')));
		session.setAttribute("usrFullName",
				properties.get("email").toString().substring(0, properties.get("email").toString().indexOf('@')));
		session.setAttribute("uNm", "flash-sso@"
				+ properties.get("email").toString().substring(0, properties.get("email").toString().indexOf('@')));
		// session.setAttribute("usrFullNameTbl", properties.get("name").toString());
		session.setAttribute("usrFullNameTbl",
				properties.get("email").toString().substring(0, properties.get("email").toString().indexOf('@')));
		// session.setAttribute("userRole",
		// authentication.getUserAuthentication().getAuthorities().toString().substring(1,
		// authentication.getUserAuthentication().getAuthorities().toString().length()-1));
		session.setAttribute("userRole", "SSO-USER");
		session.setAttribute("userEml", properties.get("email").toString());
		session.setAttribute("flashUserSSO", true);

		// modelMap.addAttribute("usrFullName", userFullName.substring(0,
		// userFullName.indexOf(' ')));
		modelMap.addAttribute("usrFullName",
				properties.get("email").toString().substring(0, properties.get("email").toString().indexOf('@')));
		modelMap.addAttribute("uNm", "flash-sso@"
				+ properties.get("email").toString().substring(0, properties.get("email").toString().indexOf('@')));
		// modelMap.addAttribute("usrFullNameTbl", properties.get("name").toString());
		modelMap.addAttribute("usrFullNameTbl",
				properties.get("email").toString().substring(0, properties.get("email").toString().indexOf('@')));
		// modelMap.addAttribute("userRole",
		// authentication.getUserAuthentication().getAuthorities().toString().substring(1,
		// authentication.getUserAuthentication().getAuthorities().toString().length()-1));
		modelMap.addAttribute("userRole", "SSO-USER");
		modelMap.addAttribute("flashUserSSO", true);
		modelMap.addAttribute("contriList", contriList);
		return "home_user";
	}

	@RequestMapping(value = "/generateOTP")
	public void generteOTP(@RequestParam String otpEmailId) throws ExecutionException, InterruptedException {
		LOG.info("OTP Generation :: Starting for email id: " + otpEmailId);

		otpEmailIdGlobal = otpEmailId;

		Random random = new Random();
		int otp = 100000 + random.nextInt(900000);

		otpCache.put(otpEmailId, otp);

		// Thread.sleep(12000);

		if (otpEmailId != null && otpEmailId.length() > 0)
			mailService.sendEmail(otpEmailId, "SAYinfos - OTP Generated",
					"Here is your OTP to login to SAYinfos: \n" + otp + "\n\n\n\n-SAYinfos");
	}

	@RequestMapping(value = "/myOTPLogin")
	public String performOTPLogin(@RequestParam(value = "OTPBoxVal", required = false) String OTPBoxVal,
			HttpSession session, RedirectAttributes redirectAtt, ModelMap modelMap) throws ExecutionException {
		LOG.info("OTP login: Started with OTP: " + OTPBoxVal);
		boolean isOkOTPLogin = false;
		String userFullNameOTP = null;
		String retrievedOTP = otpCache.get(otpEmailIdGlobal).toString();
		LOG.info("OTP login: Retrieved OTP: " + retrievedOTP);
		LOG.info("OTP login: Retrieved email id: " + otpEmailIdGlobal);
		if (session.getAttribute("flashUserOTP") != null)
			isOkOTPLogin = (boolean) session.getAttribute("flashUserOTP");
		if (session.getAttribute("userFullNameOTP") != null)
			userFullNameOTP = (String) session.getAttribute("userFullNameOTP");

		if ((OTPBoxVal != null && retrievedOTP != null && OTPBoxVal.equals(retrievedOTP)) || isOkOTPLogin) {
			otpCache.invalidate(otpEmailIdGlobal);
			String userFullName = null;
			if (otpEmailIdGlobal != null)
				userFullName = otpEmailIdGlobal;
			if (userFullNameOTP != null)
				userFullName = userFullNameOTP;
			List<Contribution> contriList = loginService.getContributions(otpEmailIdGlobal);
			if (contriList != null && contriList.size() > 0) {
				for (int i = 0; i < contriList.size(); i++) {
					contriList.get(i).setId(i + 1);
				}
			}
			session.setAttribute("userFullNameOTP", userFullName);
			session.setAttribute("usrFullName", userFullName.substring(0, userFullName.indexOf('@')));
			session.setAttribute("uNm", "flash-otp@" + userFullName.substring(0, userFullName.indexOf('@')));
			session.setAttribute("usrFullNameTbl", userFullName.substring(0, userFullName.indexOf('@')));
			session.setAttribute("userRole", "OTP-USER");
			session.setAttribute("userEml", userFullName);
			session.setAttribute("flashUserOTP", true);

			modelMap.addAttribute("usrFullName", userFullName.substring(0, userFullName.indexOf('@')));
			modelMap.addAttribute("uNm", "flash-otp@" + userFullName.substring(0, userFullName.indexOf('@')));
			modelMap.addAttribute("usrFullNameTbl", userFullName.substring(0, userFullName.indexOf('@')));
			modelMap.addAttribute("userRole", "OTP-USER");
			modelMap.addAttribute("flashUserOTP", true);
			modelMap.addAttribute("contriList", contriList);
			return "home_user";
		}
		otpCache.invalidate(otpEmailIdGlobal);
		redirectAtt.addFlashAttribute("loginFlag", 0);
		return "redirect:/";

	}

	@RequestMapping(value = "/contribute")
	public String doContribute() {
		LOG.info("In login controller contribute method..");

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
