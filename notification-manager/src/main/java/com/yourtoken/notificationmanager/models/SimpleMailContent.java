package com.yourtoken.notificationmanager.models;

// a class for set email content, when we send mail to user 
public class SimpleMailContent {
	private String emailId;
	private String subject;
	private String emailText;
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getEmailText() {
		return emailText;
	}
	public void setEmailText(String emailText) {
		this.emailText = emailText;
	}
	public SimpleMailContent() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
