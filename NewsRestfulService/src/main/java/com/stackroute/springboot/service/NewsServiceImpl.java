package com.stackroute.springboot.service;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.springboot.exception.NewsAlreadyExistsException;
import com.stackroute.springboot.exception.NewsNotFoundException;
import com.stackroute.springboot.model.News;
import com.stackroute.springboot.repository.INewsRepository;

@Service
public class NewsServiceImpl implements INewsService 
{
	@Autowired
	private INewsRepository newsrepository;
	
	@Override
	public News saveNews(News news) throws NewsAlreadyExistsException 
	{
		Optional<News> optional = this.newsrepository.findById(news.getId());

		News addedNews = null;

		if (optional.isPresent()) {
			throw new NewsAlreadyExistsException();
		}

		addedNews = this.newsrepository.save(news);

		return addedNews;
	}

	@Override
	public News updateNews(News news) throws NewsNotFoundException {
		Optional<News> optional = this.newsrepository.findById(news.getId());

		News updatedNews = null;

		if (optional.isPresent()) {
			updatedNews = this.newsrepository.save(news);
		} else {
			throw new NewsNotFoundException();
		}

		return updatedNews;
	}

	@Override
	public boolean deleteNews(String newsId) throws NewsNotFoundException {
		Optional<News> optional = this.newsrepository.findById(newsId);

		boolean deletestatus = false;

		if (optional.isPresent()) {
			this.newsrepository.delete(optional.get());
			deletestatus = true;

		} else {
			throw new NewsNotFoundException();
		}

		return deletestatus;
	}

	@Override
	public List<News> getAllNews() {
		return this.newsrepository.findAll();
	}

	@Override
	public News getNewsById(String newsId) throws NewsNotFoundException {
		Optional<News> optional = this.newsrepository.findById(newsId);

		News mynews = null;

		if (optional.isPresent()) {
			mynews = optional.get();
		} else {
			throw new NewsNotFoundException();
		}

		return mynews;
	}
}