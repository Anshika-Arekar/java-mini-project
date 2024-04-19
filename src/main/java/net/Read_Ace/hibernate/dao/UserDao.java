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
	public boolean validate(String userName, String password) {

        Transaction transaction = null;
        User user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            user = (User) session.createQuery("FROM User U WHERE U.username = :userName").setParameter("userName", userName)
                .uniqueResult();

            if (user != null && user.getPassword().equals(password)) {
                return true;
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
	}
}
