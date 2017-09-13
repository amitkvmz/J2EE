package com.info.model;

public class SmsModel 
{
	private String sender;
	private String sms;
	private String smsid;
	private String reciver;
	public SmsModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SmsModel(String sender, String sms, String smsid, String reciver) {
		super();
		this.sender = sender;
		this.sms = sms;
		this.smsid = smsid;
		this.reciver = reciver;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getSms() {
		return sms;
	}
	public void setSms(String sms) {
		this.sms = sms;
	}
	public String getSmsid() {
		return smsid;
	}
	public void setSmsid(String smsid) {
		this.smsid = smsid;
	}
	public String getReciver() {
		return reciver;
	}
	public void setReciver(String reciver) {
		this.reciver = reciver;
	}	
	
}
