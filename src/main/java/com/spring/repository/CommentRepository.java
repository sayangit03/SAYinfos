package com.spring.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.beans.Comment;

public interface CommentRepository extends MongoRepository<Comment, Integer> {
	List<Comment> findByQuestionNum(String questionNum);
}
