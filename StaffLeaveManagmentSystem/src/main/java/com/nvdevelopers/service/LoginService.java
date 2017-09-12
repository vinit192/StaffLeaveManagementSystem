package com.nvdevelopers.service;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Query;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.nvdevelopers.dto.UserDetails;

@Service
public class LoginService {
	
	SessionFactory sessionFactory;
	Session session;
	List<UserDetails> userDetails = null;
	static UserDetails users;

	public boolean validateUser(String username, String password, ModelMap model)
	{
		boolean isLogin = false;
		sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from UserDetails where username = ? and password = ?");
		query.setString(0, username);
		query.setString(1, password);
		
		userDetails = query.list();
		if (userDetails.size() == 1) {
			isLogin = true;
		}
		else {
			isLogin = false;
		}
		
		Iterator it = userDetails.listIterator();
		
		while(it.hasNext())
		{
			users = (UserDetails) it.next();
			model.put("staffId", users.getStaffId());
			model.put("name", users.getName());
			model.put("email", users.getEmail());
			model.put("username", users.getUsername());
			model.put("contactno", users.getContactno());
		}
		
		session.getTransaction().commit();
		session.close();
		
		return isLogin;
	}
	
}
