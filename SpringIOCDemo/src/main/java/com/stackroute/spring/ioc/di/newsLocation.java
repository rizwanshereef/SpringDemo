package com.stackroute.spring.ioc.di;

public class newsLocation 
{
	private int id;
	private String city;
	private String Country;
	
	public newsLocation(int id, String city, String country) 
	{
		super();
		this.id = id;
		this.city = city;
		Country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	@Override
	public String toString() {
		return "newsLocation [id=" + id + ", city=" + city + ", Country=" + Country + "]";
	}
}
