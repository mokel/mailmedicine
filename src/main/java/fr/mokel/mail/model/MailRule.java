package fr.mokel.mail.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MailRule {

	@Id
	@GeneratedValue
	private long id;
	
	private String regexSender;

	private String regexSubject;

	public String getRegexSender() {
		return regexSender;
	}

	public void setRegexSender(String regexSender) {
		this.regexSender = regexSender;
	}

	public String getRegexSubject() {
		return regexSubject;
	}

	public void setRegexSubject(String regexSubject) {
		this.regexSubject = regexSubject;
	}
	
	
}
