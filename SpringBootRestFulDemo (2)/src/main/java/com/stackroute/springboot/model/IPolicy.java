package com.stackroute.springboot.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
//@Table(name="ipolicy")
public class IPolicy {

	@Id
//	@Column(name="ipId")
	private int ipId;
	private String ipTitle;
	private String ipDesc;
	private int ipPremium;

	public int getIpId() {
		return ipId;
	}

	public void setIpId(int ipId) {
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
