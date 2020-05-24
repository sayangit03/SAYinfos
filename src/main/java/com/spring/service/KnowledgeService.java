package com.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.beans.Comment;
import com.spring.beans.Contribution;
import com.spring.repository.CommentRepository;
import com.spring.repository.ContributionRepository;

@Service
public class KnowledgeService {

	@Autowired
	ContributionRepository contriRepo;
	
	@Autowired
	CommentRepository commentRepository;
	
	public List<Contribution> getKnowledges(String topic) {
		List<Contribution> knowledgeContri = contriRepo.findByContriTopic(topic);
		return knowledgeContri;
	}
	
	public int saveComment(Comment cmnt) {
		if(cmnt.getCmntName()==null || cmnt.getCmntName()=="") {
			cmnt.setCmntName("Anonymous");
		}
		cmnt.setCmntDate(new Date());
		Comment comm = commentRepository.save(cmnt);
		return comm.getId();
	}
	
	public List<Comment> fetchComments(String questionNum){
		List<Comment> commentList = commentRepository.findByQuestionNum(questionNum);
		return commentList;
	}
}
