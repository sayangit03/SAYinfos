package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.beans.Comment;
import com.spring.beans.Contribution;
import com.spring.service.KnowledgeService;

@Controller
public class KnowledgeController {
	
	@Autowired
	KnowledgeService knowledgeService;

	@RequestMapping("/enKnow/{domain}/{topic}")
	public String fetchKnowledge(@PathVariable String domain, @PathVariable String topic, ModelMap modelMap, RedirectAttributes redirectAtt) {
		List<Contribution> knowledgeList = knowledgeService.getKnowledges(topic);
		
		for(Contribution c : knowledgeList) {
			List<Comment> cmntList = knowledgeService.fetchComments(String.valueOf(c.getId()));
			c.setCmntList(cmntList);
		}
		
		//modelMap.addAttribute("knowledgeList", knowledgeList);
		redirectAtt.addFlashAttribute("domain", domain);
		redirectAtt.addFlashAttribute("topic", topic);
		redirectAtt.addFlashAttribute("knowledgeList", knowledgeList);
		return "redirect:/enhanceKnowledge";
	}
	
	@RequestMapping("/enhanceKnowledge")
	public String redirectKnowledge(Model model, ModelMap modelMap) {
		List<Contribution> knowledgeList = (List<Contribution>) model.asMap().get("knowledgeList");
		String domain = (String) model.asMap().get("domain");
		String topic = (String) model.asMap().get("topic");
		modelMap.addAttribute("knowledgeList", knowledgeList);
		if(domain!=null)
			modelMap.addAttribute("domain", domain);
		if(topic!=null)
			modelMap.addAttribute("topic", topic.replaceAll("_", " "));
		return "knowledge_java";
	}
	
	@RequestMapping("/makeComment")
	public String makeComment(Comment cmnt) {
		System.out.println(">>>>>>>>>>>>>> "+cmnt.getQuestionNum());
		knowledgeService.saveComment(cmnt);
		return "redirect:/enKnow/"+cmnt.getDomain()+"/"+cmnt.getTopic();
	}
}
