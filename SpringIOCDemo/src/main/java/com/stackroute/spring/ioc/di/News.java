package com.stackroute.spring.ioc.di;

import java.util.List;

public class News {

	private int id;
	private String newsTitle;
	private String newsContent;

//	private newsLocation newsL;

	private List<newsLocation> newsL;

	public News(int id, String newsTitle, String newsContent, List<newsLocation> newsL) {
		super();
		this.id = id;
		this.newsTitle = newsTitle;
		this.newsContent = newsContent;
		this.newsL = newsL;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getNewsContent() {
		return newsContent;
	}

	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}

	public List<newsLocation> getNewsL() {
		return newsL;
	}

	public void setNewsL(List<newsLocation> newsL) {
		this.newsL = newsL;
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", newsTitle=" + newsTitle + ", newsContent=" + newsContent + ", newsL=" + newsL
				+ "]";
	}

}

// News nobj = new News(1,"Festival","Durga Pooja Celebration Begin");
//News nobj = new News();

//News nobj = new News(1,"Festival","Durga Pooja Celebration Begin",new newsLocation(1,"Pune","India"));
