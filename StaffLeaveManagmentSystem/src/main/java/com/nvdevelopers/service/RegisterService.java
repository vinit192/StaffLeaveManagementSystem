package com.nvdevelopers.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import com.nvdevelopers.dto.UserDetails;

@Service
public class RegisterService {
	
	SessionFactory sessionFactory;
	Session session;
	
	public boolean saveUser(String name, String email, 
			String username, String password,
			String contactno) 
	{
		boolean isRegister = false;
		UserDetails user = new UserDetails();
		user.setName(name);
		user.setEmail(email);
		user.setUsername(username);
		user.setPassword(password);
		user.setContactno(contactno);
		user.setTotalLeaves(10);
		
		sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		if(session.save(user) != null){
			isRegister = true;
		}
		session.getTransaction().commit();
		return isRegister;
	}
}
