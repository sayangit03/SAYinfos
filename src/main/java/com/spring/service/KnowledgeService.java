package com.spring.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

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
		cmnt.setId((int) commentRepository.count() + 1);
		if (cmnt.getCmntName() == null || cmnt.getCmntName() == "") {
			cmnt.setCmntName("Anonymous");
		}
		cmnt.setCmntDate(new Date());
		Comment comm = commentRepository.save(cmnt);
		return comm.getId();
	}

	public List<Comment> fetchComments(String questionNum) {
		List<Comment> commentList = commentRepository.findByQuestionNum(questionNum);
		for (Comment comment : commentList) {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			TimeZone tz = TimeZone.getTimeZone("IST");
			df.setTimeZone(tz);
			try {
				comment.setCmntDate(df1.parse(df.format(comment.getCmntDate())));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return commentList;
	}
}
