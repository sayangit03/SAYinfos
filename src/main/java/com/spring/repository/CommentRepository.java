package com.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.beans.Comment;
import com.spring.beans.Contribution;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
	List<Comment> findByQuestionNum(String questionNum);
}
