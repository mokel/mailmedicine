package fr.mokel;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.mokel.mail.model.MailAccount;
import fr.mokel.mail.model.MailRule;

public class MailAccountIntegrationTest {

	private static Context context;
	
	@BeforeClass
	public static void setup() {
		final Properties p = new Properties();
        p.put("raspDatabase", "new://Resource?type=DataSource");
        p.put("raspDatabase.JdbcDriver", "org.hsqldb.jdbcDriver");
        p.put("raspDatabase.JdbcUrl", "jdbc:hsqldb:mem:raspdb");

        context = EJBContainer.createEJBContainer(p).getContext();		
	}
	
	private static MailAccount create(String suffix) {
		MailAccount ma = new MailAccount();
		ma.setEmail("email"+suffix);
		ma.setLogin("login"+suffix);
		ma.setPassword("password"+suffix);
		ma.setImapServer("imapServer"+suffix);

		List<MailRule> list = new ArrayList<MailRule>();
		MailRule mr = new MailRule();
		mr.setRegexSender("regexsender"+suffix);
		mr.setRegexSubject("regexsubject"+suffix);
		list.add(mr);
		ma.setRules(list);
		return ma;
	}
	
	@Test
    public void testCrud() throws Exception {
		MailAccountServices service = (MailAccountServices) context.lookup("java:global/myraspserver/MailAccountServices");

        service.persist(create(""));
        service.persist(create(""));
        MailAccount ma = create("-test");
        service.persist(ma);
        long id = ma.getId();
		
        List<MailAccount> list = service.getAccounts();
        assertEquals("List.size()", 3, list.size());

        MailAccount ma2 = service.findById(id);
        Assert.assertNotNull(ma2);
        Assert.assertEquals("login-test", ma.getLogin());
        Assert.assertEquals("email-test", ma.getEmail());
        Assert.assertEquals("imapServer-test", ma.getImapServer());
        Assert.assertEquals("password-test", ma.getPassword());
        Assert.assertNotNull(ma.getRules());
        Assert.assertEquals(1, ma.getRules().size());
        Assert.assertEquals("regexsender-test", ma.getRules().get(0).getRegexSender());
        Assert.assertEquals("regexsubject-test", ma.getRules().get(0).getRegexSubject());
        

        service.remove(ma2);
        
        MailAccount ma3 = service.findById(id);
        Assert.assertNull(ma3);
        
    }
	
}
