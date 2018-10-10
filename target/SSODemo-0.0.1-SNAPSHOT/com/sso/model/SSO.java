package com.sso.model;
import java.util.Date;
public class SSO {
	private int ssoRequestId;
	private String purpose;
	private String prodURL;
	private Date prodDeployDate;
	private String testURL;
	private Date testDeployDate;
	private String twoFactorAuthentication;
	private int technicalId;
	private int requesterId;

	public int getSsoRequestId() {
		return ssoRequestId;
	}
	public void setSsoRequestId(int ssoRequestId) {
		this.ssoRequestId = ssoRequestId;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getProdURL() {
		return prodURL;
	}
	public void setProdURL(String prodURL) {
		this.prodURL = prodURL;
	}
	public Date getProdDeployDate() {
		return prodDeployDate;
	}
	public void setProdDeployDate(Date prodDeployDate) {
		this.prodDeployDate = prodDeployDate;
	}
	public String getTestURL() {
		return testURL;
	}
	public void setTestURL(String testURL) {
		this.testURL = testURL;
	}
	public Date getTestDeployDate() {
		return testDeployDate;
	}
	public void setTestDeployDate(Date testDeployDate) {
		this.testDeployDate = testDeployDate;
	}
	public String getTwoFactorAuthentication() {
		return twoFactorAuthentication;
	}
	public void setTwoFactorAuthentication(String twoFactorAuthentication) {
		this.twoFactorAuthentication = twoFactorAuthentication;
	}
	public int getTechnicalId() {
		return technicalId;
	}
	public void setTechnicalId(int technicalId) {
		this.technicalId = technicalId;
	}
	public int getRequesterId() {
		return requesterId;
	}
	public void setRequesterId(int requesterId) {
		this.requesterId = requesterId;
	}

}
