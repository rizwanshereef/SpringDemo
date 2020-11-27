package com.stackroute.spring.ioc.di.model;

public class IPolicy 
{
	private int ipId;
	private String ipTitle;
	private String ipDesc;
	private int ipPremium;
	
	
	public IPolicy(int ipId, String ipTitle, String ipDesc, int ipPremium) {
		super();
		this.ipId = ipId;
		this.ipTitle = ipTitle;
		this.ipDesc = ipDesc;
		this.ipPremium = ipPremium;
	}

		

	@Override
	public String toString() {
		return "IPolicy [ipId=" + ipId + ", ipTitle=" + ipTitle + ", ipDesc=" + ipDesc + ", ipPremium=" + ipPremium
				+ "]";
	}


	public IPolicy() 
	{
		// TODO Auto-generated constructor stub
	}


	public int getIpId() {
		return ipId;
	}


	public IPolicy setIpId(int ipId) {
		this.ipId = ipId;
		return this;
	}


	public String getIpTitle() {
		return ipTitle;
	}


	public IPolicy setIpTitle(String ipTitle) {
		this.ipTitle = ipTitle;
		return this;
	}


	public String getIpDesc() {
		return ipDesc;
	}


	public IPolicy setIpDesc(String ipDesc) {
		this.ipDesc = ipDesc;
		return this;
	}


	public int getIpPremium() {
		return ipPremium;
	}


	public IPolicy setIpPremium(int ipPremium) {
		this.ipPremium = ipPremium;
		return this;
	}
}
