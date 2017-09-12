package com.nvdevelopers.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import com.nvdevelopers.dto.UserDetails;

@Service
public class GrantLeaveService {
	SessionFactory sessionFactory;
	Session session;
	
	public boolean grantLeave(int leaveId, int staffId, String to, String from)
	{
		char[] toDateArray = to.toCharArray();
		char[] fromDateArray = from.toCharArray();
		int toDate = 0, fromDate = 0;
		toDate = toDateArray[toDateArray.length-2] - '0';
		fromDate = fromDateArray[fromDateArray.length-2] - '0';
		toDate = toDate * 10;
		fromDate = fromDate * 10;
		toDate = toDate + ((toDateArray[toDateArray.length-1]) - '0');
		fromDate = fromDate + ((fromDateArray[fromDateArray.length-1]) - '0');
		
		System.out.println("to : " + toDate);
		System.out.println("from : " + fromDate);
		int leaves = fromDate - toDate;
		System.out.println("leaves : " + leaves);
		boolean isGrant = false;
		sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		
		
		UserDetails user = session.get(UserDetails.class, staffId);
		if ((user.getTotalLeaves() == 0) || (user.getTotalLeaves() < leaves)) {
			Query query = session.createQuery("update LeaveRecords l set l.Granted = ? where leaveId = ?");
			query.setParameter(0, "rejected");
			query.setInteger(1, leaveId);
			
			query.executeUpdate();
			isGrant = false;
		}
		else {
			Query query = session.createQuery("update LeaveRecords l set l.Granted = ? where leaveId = ?");
			query.setParameter(0, "granted");
			query.setInteger(1, leaveId);
			
			query.executeUpdate();
			user.setTotalLeaves(user.getTotalLeaves() - leaves);
			session.save(user);
			isGrant = true;
		}
		
		session.getTransaction().commit();
		return isGrant;
	}
	
	public void rejectLeave(int leaveId)
	{
		sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("update LeaveRecords l set l.Granted = ? where leaveId = ?");
		query.setParameter(0, "rejected");
		query.setInteger(1, leaveId);
		
		query.executeUpdate();
		session.getTransaction().commit();
	}
}
