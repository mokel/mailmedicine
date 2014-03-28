package fr.mokel.mail.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class MailAccount {

	@Id
	@GeneratedValue
	private long id;

	private String login;
	private String email;
    private String password;
    private String imapServer;

    @OneToMany(cascade=CascadeType.ALL)
    private List<MailRule> rules;
    
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<MailRule> getRules() {
		return rules;
	}

	public void setRules(List<MailRule> rules) {
		this.rules = rules;
	}

	public String getImapServer() {
		return imapServer;
	}

	public void setImapServer(String imapServer) {
		this.imapServer = imapServer;
	}

	
}
