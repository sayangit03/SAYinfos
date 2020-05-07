package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.beans.Article;
import com.spring.beans.News;
import com.spring.beans.Sorce;
import com.spring.resource.NewsResource;

@Controller
public class NewsController {
	
	@Autowired
	NewsResource newsResource;

	@GetMapping("/news")
	public String getNews(Sorce sorce, ModelMap modelMap){
		String search=sorce.getName();
		System.out.println("From news controller: "+search);
		News news = newsResource.getAllNews(search);
		//System.out.println("From news controller: "+news.getArticleList().get(0).getContent());
		
		for(int i=0; i<news.getArticleList().size(); i++) {
			news.getArticleList().get(i).setId(i+1);
		}
		modelMap.addAttribute("articleList", news.getArticleList());
		return "news_all";
	}
	
	/*
	 * @GetMapping("/searchNews") public String searchNews() {
	 * 
	 * }
	 */
}
