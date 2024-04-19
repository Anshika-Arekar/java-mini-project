package net.Read_Ace.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import net.Read_Ace.hibernate.model.User;
import net.Read_Ace.hibernate.util.HibernateUtil;

public class UserDao {
	public void saveUser(User user) {
		Transaction tx = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			session.save(user);
			tx.commit();
		} catch(Exception e) { 
			if(tx != null) tx.rollback();
		}
	}
}
