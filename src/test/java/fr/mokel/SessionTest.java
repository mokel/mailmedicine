package fr.mokel;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;

public class SessionTest {

	public static void main(String[] args) throws MessagingException, InterruptedException {
		final String port = "993";

		Properties prop = new Properties();

		// I assume there is some redundancy here but this didn't cause any problems so far
		prop.setProperty("mail.imaps.starttls.enable", "true");
		prop.setProperty("mail.imaps.port", port);
		prop.setProperty("mail.imap.ssl.enable", "true");//sure?
		prop.setProperty("mail.debug", "false");

		// Create a session before you loop since the configuration doesn't change
		Session session = Session.getInstance(prop);

		// Nearly loop forever in Prod
		while(true){

		    // Check the INBOX and do some other stuff
		    Store store = session.getStore("imaps");
		    store.connect("host", "user", "pw");
		    // ... the operations on the session ... 

		    store.close();

		// Sleep a bit try & catch removed
		Thread.sleep(1000);
		}
	}
}
