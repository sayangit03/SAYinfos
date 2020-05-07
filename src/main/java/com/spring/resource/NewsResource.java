package com.spring.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.spring.beans.News;


@Service
public class NewsResource {
	
	@Autowired
	Environment env;
	
	@Autowired
	private RestTemplate restTemplate;

	public News getAllNews(String search){
		System.out.println("From news resource: "+search);
		String url = "http://newsapi.org/v2/everything?q=india&sortBy=publishedAt&apiKey="+env.getProperty("news.key");
		if(search!=null && search!="")
			url = "http://newsapi.org/v2/everything?q="+search+"&sortBy=publishedAt&apiKey="+env.getProperty("news.key");
		//System.out.println(url);
		News news = restTemplate.getForObject(url, News.class);
		//System.out.println("From news service: "+news.getArticleList().get(0).getContent());
		return news;
	}
}
