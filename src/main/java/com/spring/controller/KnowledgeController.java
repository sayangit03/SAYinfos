package com.spring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
	public String fetchKnowledge(@PathVariable String domain, @PathVariable String topic, ModelMap modelMap, RedirectAttributes redirectAtt, Model model, HttpSession session) {
		session.setAttribute("kDomain", domain);
		session.setAttribute("kTopic", topic);
		boolean cmntFlag = false;
		String questionNumber = null;
		int cmntId = 0;
		int showCmntListSize = 0;
		if(model.asMap().get("cmntFlag")!=null) {
			cmntFlag = (boolean) model.asMap().get("cmntFlag");
			questionNumber = (String) model.asMap().get("questionNumber");
			cmntId = (int) model.asMap().get("cmntId");
		}

		List<Contribution> knowledgeList = knowledgeService.getKnowledges(topic);

		for(Contribution c : knowledgeList) {
			List<Comment> cmntList = knowledgeService.fetchComments(String.valueOf(c.getId()));
			c.setCmntList(cmntList);
			if(cmntFlag && questionNumber!=null && c.getId()==Integer.parseInt(questionNumber)) {
				showCmntListSize = cmntList.size();
			}
		}

		//modelMap.addAttribute("knowledgeList", knowledgeList);
		redirectAtt.addFlashAttribute("domain", domain);
		redirectAtt.addFlashAttribute("topic", topic);
		redirectAtt.addFlashAttribute("knowledgeList", knowledgeList);
		System.out.println("Goto: #c"+questionNumber+""+cmntId);
		if(cmntFlag) {
			redirectAtt.addFlashAttribute("cmntFlag", cmntFlag);
			redirectAtt.addFlashAttribute("questionNumber", questionNumber);
			if(showCmntListSize>2) {
				int finalShowCmntListSize = showCmntListSize-2;
				return "redirect:/enhanceKnowledge#c"+questionNumber+""+finalShowCmntListSize;
			}
			else {
				return "redirect:/enhanceKnowledge#cm"+questionNumber;
			}
		}

		return "redirect:/enhanceKnowledge";
	}

	@RequestMapping("/enhanceKnowledge")
	public String redirectKnowledge(Model model, ModelMap modelMap, HttpSession session) {
		String kDomain=null;
		String kTopic=null;
		if(session.getAttribute("kDomain")!=null && session.getAttribute("kTopic")!=null) {
			kDomain = session.getAttribute("kDomain").toString();
			kTopic = session.getAttribute("kTopic").toString();
		}
		else {
			kDomain = "java";
			kTopic = "Java_Basics";
		}
		List<Contribution> knowledgeList = (List<Contribution>) model.asMap().get("knowledgeList");
		String domain = (String) model.asMap().get("domain");
		String topic = (String) model.asMap().get("topic");
		if(domain==null) {
			return "redirect:/enKnow/"+kDomain+"/"+kTopic;
		}
		boolean cmntFlag = false;
		String questionNumber = null;
		if(model.asMap().get("cmntFlag")!=null) {
			cmntFlag = (boolean) model.asMap().get("cmntFlag");
			questionNumber = (String) model.asMap().get("questionNumber");
		}
		modelMap.addAttribute("knowledgeList", knowledgeList);
		if(domain!=null)
			modelMap.addAttribute("domain", domain);
		if(topic!=null)
			modelMap.addAttribute("topic", topic.replaceAll("_", " "));
		System.out.println("Final question number: "+questionNumber);
		modelMap.addAttribute("cmntFlag", cmntFlag);
		modelMap.addAttribute("questionNumber", questionNumber);
		return "knowledge_java";
	}

	@RequestMapping("/makeComment")
	public String makeComment(Comment cmnt, RedirectAttributes redirectAtt) {
		System.out.println("Commenting on question actual number: "+cmnt.getQuestionNum());
		int cmntId = knowledgeService.saveComment(cmnt);
		redirectAtt.addFlashAttribute("cmntFlag", true);
		redirectAtt.addFlashAttribute("questionNumber", cmnt.getQuestionNum());
		redirectAtt.addFlashAttribute("cmntId", cmntId);
		return "redirect:/enKnow/"+cmnt.getDomain()+"/"+cmnt.getTopic();
	}
}
