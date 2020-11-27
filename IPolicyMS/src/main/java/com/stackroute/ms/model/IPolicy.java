package com.stackroute.ms.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class IPolicy 
{
	@Id
	private String ipId;
	private String ipTitle;
	private String ipDesc;
	private int ipPremium;
	public String getIpId() {
		return ipId;
	}
	public void setIpId(String ipId) {
		this.ipId = ipId;
	}
	public String getIpTitle() {
		return ipTitle;
	}
	public void setIpTitle(String ipTitle) {
		this.ipTitle = ipTitle;
	}
	public String getIpDesc() {
		return ipDesc;
	}
	public void setIpDesc(String ipDesc) {
		this.ipDesc = ipDesc;
	}
	public int getIpPremium() {
		return ipPremium;
	}
	public void setIpPremium(int ipPremium) {
		this.ipPremium = ipPremium;
	}
	@Override
	public String toString() {
		return "IPolicy [ipId=" + ipId + ", ipTitle=" + ipTitle + ", ipDesc=" + ipDesc + ", ipPremium=" + ipPremium
				+ "]";
	}	
}
