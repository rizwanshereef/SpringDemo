package com.stackroute.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.springboot.exception.NewsAlreadyExistsException;
import com.stackroute.springboot.exception.NewsNotFoundException;
import com.stackroute.springboot.model.News;
import com.stackroute.springboot.service.INewsService;

@RestController
@RequestMapping("api/v1")
public class NewsController {

	// http://localhost:8080/api/v1/saveNews
	// http://localhost:8080/api/v1/getNews
	// http://localhost:8080/api/v1/updateNews
	// http://localhost:8080/api/v1/deleteNews
	// http://localhost:8080/api/v1/getNewsById

	@Autowired
	private INewsService newsservice;

	private ResponseEntity responseentity;

	@PostMapping("/addnews")
	public ResponseEntity<?> saveNews(@RequestBody News news) throws NewsAlreadyExistsException {
		try {
			News createdNews = newsservice.saveNews(news);
			responseentity = new ResponseEntity(createdNews, HttpStatus.CREATED);

		} catch (NewsAlreadyExistsException naee) {
			responseentity = new ResponseEntity<>("Some Internal Error ..", HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception eobj) {
			throw eobj;
		}

		return responseentity;
	}

	@GetMapping("/newsdata")
	public ResponseEntity<?> getNews() {
		try {
			responseentity = new ResponseEntity<>(newsservice.getAllNews(), HttpStatus.OK);

		} catch (Exception e) {
			responseentity = new ResponseEntity<>("Something went wrong, Could not process the request",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseentity;
	}

	@PutMapping("/updatenews")
	public ResponseEntity<?> updateNews(@RequestBody News news) throws NewsNotFoundException {
		try {
			News updatedNews = newsservice.updateNews(news);
			responseentity = new ResponseEntity<>(updatedNews, HttpStatus.CREATED);

		} catch (NewsNotFoundException nnfe) {
			throw new NewsNotFoundException();
		}

		return responseentity;
	}

	@GetMapping("/newsdata/{id}")
	public ResponseEntity<?> getNewsById(@PathVariable("id") String newsId) throws NewsNotFoundException {
		try {

			News newsobj = newsservice.getNewsById(newsId);
			responseentity = new ResponseEntity<>(newsobj, HttpStatus.OK);

		} catch (NewsNotFoundException e) {
			responseentity = new ResponseEntity<>("Something went wrong, Could not process the request",
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return responseentity;
	}

	@DeleteMapping("/deleteNews/{id}")
	public ResponseEntity<?> deleteNews(@PathVariable("id") String newsId) throws NewsNotFoundException {
		try {

			Boolean status = newsservice.deleteNews(newsId);
			responseentity = new ResponseEntity<>("News Deleted", HttpStatus.OK);

		} catch (NewsNotFoundException e) {
			responseentity = new ResponseEntity<>("Something went wrong while deleting news",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return responseentity;
	}
}
