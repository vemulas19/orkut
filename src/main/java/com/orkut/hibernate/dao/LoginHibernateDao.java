package com.orkut.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.springframework.ui.Model;

import com.orkut.interf.dao.ILoginDao;
import com.orkut.pojo.Student;

public class LoginHibernateDao implements ILoginDao {

	
	public String loginUser(Student stud, Model model1) {
		SessionFactory sessionfactory = null;
		Configuration configure = new AnnotationConfiguration().configure("hibernate.cfg.xml");

		sessionfactory = configure.buildSessionFactory();
		System.out.println("Hibernate database logic!!");
		Session session = sessionfactory.openSession();
		
		Transaction txn = session.beginTransaction();
		session.save(stud);
		txn.commit();
		model1.addAttribute("message", "Succssfully Registered!!");
		return "result";
	}

	public void getAllStud(String name) {
		System.out.println("testing");
	}

}
