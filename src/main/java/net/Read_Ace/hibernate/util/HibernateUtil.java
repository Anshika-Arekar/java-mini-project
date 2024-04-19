package net.Read_Ace.hibernate.util;

import java.util.Properties;

import org.hibernate.*;
import org.hibernate.boot.registry.*;
import org.hibernate.cfg.*;

import net.Read_Ace.hibernate.model.User;

public class HibernateUtil {
	private static SessionFactory sf;
	public static SessionFactory getSessionFactory() {
		if(sf == null) {
			try {
				Configuration cfg = new Configuration();
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/javahibernate?useSSL=false");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "arnav");
				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				settings.put(Environment.HBM2DDL_AUTO, "update");
				cfg.setProperties(settings);
				cfg.addAnnotatedClass(User.class);
				StandardServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
				sf = cfg.buildSessionFactory(sr);
			} catch(Exception e) { System.out.println(e); }
		}
		return sf;
	}
}
