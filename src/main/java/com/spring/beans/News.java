package com.spring.beans;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonSetter;

public class News {
String status;
int totalResult;
List<Article> articleList;
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public int getTotalResult() {
	return totalResult;
}
public void setTotalResult(int totalResult) {
	this.totalResult = totalResult;
}
public List<Article> getArticleList() {
	return articleList;
}

@JsonSetter("articles")
public void setArticleArr(List<Article> articleList) {
	this.articleList = articleList;
}

}
