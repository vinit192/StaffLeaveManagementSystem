package com.nvdevelopers.service;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.nvdevelopers.dto.UserDetails;

@Service
public class FetchRecordsService {

	SessionFactory sessionFactory;
	Session session;
	
	public List showAllRecords()
	{
		List user;
		
		sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from UserDetails");
		user = query.list();
		
		session.getTransaction().commit();
		
		//System.out.println(user.size());
		
		return user;
	}
	
	public void showAdminRecord(String username, String password, ModelMap model)
	{
		List admin;
		
		sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from UserDetails where username = ? and password = ?");
		query.setString(0, username);
		query.setString(1, password);
		
		admin = query.list();
		session.getTransaction().commit();
		
		Iterator it = admin.listIterator();
		
		while (it.hasNext()) {
			UserDetails userAdmin = (UserDetails) it.next();
			model.put("staffid", userAdmin.getStaffId());
			model.put("name", userAdmin.getName());
			model.put("email", userAdmin.getEmail());
			model.put("contactno", userAdmin.getContactno());
		}
	}
	
	public void showHODRecord(String username, String password, ModelMap model)
	{
		List hod;
		
		sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from UserDetails where username = ? and password = ?");
		query.setString(0, username);
		query.setString(1, password);
		
		hod = query.list();
		session.getTransaction().commit();
		
		Iterator it = hod.listIterator();
		
		while (it.hasNext()) {
			UserDetails userhod = (UserDetails) it.next();
			model.put("staffid", userhod.getStaffId());
			model.put("name", userhod.getName());
			model.put("email", userhod.getEmail());
			model.put("contactno", userhod.getContactno());
		}
	}
	
	public List showAllLeaveRecord() 
	{
		List allLeaveRecord;
		
		sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from LeaveRecords");
		allLeaveRecord = query.list();
		
		session.getTransaction().commit();
		return allLeaveRecord;
	}
	
	public List showAllPendingLeaveRecords()
	{
		List allPendingLeaveRecords;
		
		sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from LeaveRecords where Granted = ?");
		query.setString(0, "pending");
		allPendingLeaveRecords = query.list();
		
		session.getTransaction().commit();
		return allPendingLeaveRecords;
	}
	
	public List showAllRejectedLeaveRecords()
	{
		List allRejectedLeaveRecords;
		
		sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from LeaveRecords where Granted = ?");
		query.setString(0, "rejected");
		allRejectedLeaveRecords = query.list();
		
		session.getTransaction().commit();
		return allRejectedLeaveRecords;
	}
}
