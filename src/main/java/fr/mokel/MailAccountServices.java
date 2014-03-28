package fr.mokel;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.mokel.mail.model.MailAccount;

@Stateless
public class MailAccountServices {

	@PersistenceContext
	private EntityManager em;

	public void persist(MailAccount account) throws Exception {
		em.persist(account);
	}

	public void remove(MailAccount account) throws Exception {
		MailAccount ma = em.merge(account);
		em.remove(ma);
	}

	public List<MailAccount> getAccounts() throws Exception {
		TypedQuery<MailAccount> query = em.createQuery("SELECT a from MailAccount as a",
				MailAccount.class);
		return query.getResultList();
	}

	public MailAccount load(String login) {
		TypedQuery<MailAccount> query = em.createQuery(
				"SELECT a from MailAccount as a WHERE a.login = :param_login",
				MailAccount.class).setParameter("param_login", login);
		List<MailAccount> list = query.getResultList();
		if (!list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}
	
	public MailAccount findById(long id) {
		return em.find(MailAccount.class, id);
	}
}
