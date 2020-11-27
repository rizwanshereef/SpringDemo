package com.stackroute.springboot.service;

import java.util.List;

import com.stackroute.springboot.exception.NewsAlreadyExistsException;
import com.stackroute.springboot.exception.NewsNotFoundException;
import com.stackroute.springboot.model.News;

public interface INewsService 
{
	public News saveNews(News news) throws NewsAlreadyExistsException;

	public News updateNews(News news) throws NewsNotFoundException;

	public boolean deleteNews(String newsId) throws NewsNotFoundException;

	public List<News> getAllNews();

	public News getNewsById(String newsId) throws NewsNotFoundException;
}


// SpringMVC
// URL to get the service?username="xyz"
// SpringRestful Service
// URI to get the service specify the path/1