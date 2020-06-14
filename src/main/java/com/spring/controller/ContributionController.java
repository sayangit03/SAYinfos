package com.spring.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.beans.Contribution;
import com.spring.service.ContributionService;

@Controller
public class ContributionController {

	@Autowired
	ContributionService contriService;

	@RequestMapping(value = "/makeContribution")
	public String makeContribution(Contribution contri, HttpSession session) {
		System.out.println("In contribution controller | making contribution");
		if(session.getAttribute("uNm")!=null && session.getAttribute("userEml")!=null) {
			contri.setUserUniqueName(session.getAttribute("uNm").toString());
			contri.setEmailId(session.getAttribute("userEml").toString());
			contri.setUserName(session.getAttribute("usrFullNameTbl").toString());
			contri.setContriDate(new Date());
			contri.setContriStatus(false);
			contriService.saveContribution(contri);
		}
		if((boolean) session.getAttribute("flashUser")) {
			return "redirect:ssoLogin";
		}
		return "redirect:mylogin";
	}
	
	@RequestMapping(value = "/editContribution")
	public String editContribution(Contribution contri) {
		boolean result = contriService.saveEditedContribution(contri);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> "+result);
		return "redirect:mylogin";
	}

	@RequestMapping(value = "/userContri/{email}/{name}")
	public String checkContribution(@PathVariable String email,@PathVariable String name, RedirectAttributes redirectAtt) {
		System.out.println(">>>>>>> "+email);

		List<Contribution> list = new ArrayList<>(); 
		list = contriService.getUserContributions(email);
		System.out.println("Contribution by user: "+list.size());
		redirectAtt.addFlashAttribute("contriList", list);
		redirectAtt.addFlashAttribute("name", name);
		return "redirect:/contributionsByUser";
	}

	@RequestMapping(value = "/contributionsByUser")
	public String checkContributionFinal(ModelMap modelMap, Model model) {
		
		List<Contribution> list = new ArrayList<>();
		list = (List<Contribution>) model.asMap().get("contriList");
		/*
		 * if(list!=null && list.size()>0) { for(int i=0; i<list.size(); i++) {
		 * list.get(i).setId(i+1); } }
		 */
		String name = null;
		if(model.asMap().get("name")!=null)
			name =  model.asMap().get("name").toString();
		modelMap.addAttribute("contriList", list);
		modelMap.addAttribute("name", name);
		return "user_contribution";
	}
	
	@RequestMapping(value = "/approveContri/{id}")
	public String approveContri(@PathVariable int id) {
		System.out.println("Contri id: "+id);
		contriService.approveContriById(id);
		return "redirect:/redirectToLogin";
	}
	
	@RequestMapping(value = "/editContri/{id}")
	public String editContri(@PathVariable int id, RedirectAttributes redirectAtt) {
		System.out.println("Contri id: "+id);
		Contribution contri = contriService.editContriById(id);
		redirectAtt.addFlashAttribute("contri", contri);
		return "redirect:/contriById";
	}
	
	@RequestMapping(value = "/contriById")
	public String redirectToEditContriPage(Model model, ModelMap modelMap) {
		Contribution contri = new Contribution();
		contri = (Contribution) model.asMap().get("contri");
		modelMap.addAttribute("contri", contri);
		return "home_user_contribute_edit";
	}
	
	@RequestMapping(value = "/redirectToLogin")
	public String redirectAfterApproveOrEdit() {
		System.out.println("k");
		return "redirect:mylogin";
	}
	
}
