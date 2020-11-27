package com.stackroute.springboot.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class News 
{
	private String id;
	private String newstitle;
	private String newstext;
	private String newscategory;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNewstitle() {
		return newstitle;
	}
	public void setNewstitle(String newstitle) {
		this.newstitle = newstitle;
	}
	public String getNewstext() {
		return newstext;
	}
	public void setNewstext(String newstext) {
		this.newstext = newstext;
	}
	public String getNewscategory() {
		return newscategory;
	}
	public void setNewscategory(String newscategory) {
		this.newscategory = newscategory;
	}
	@Override
	public String toString() {
		return "News [id=" + id + ", newstitle=" + newstitle + ", newstext=" + newstext + ", newscategory="
				+ newscategory + "]";
	}
}
