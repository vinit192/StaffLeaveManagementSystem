package com.nvdevelopers.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import com.nvdevelopers.dto.LeaveRecords;

@Service
public class ApplyLeaveService {

	SessionFactory sessionFactory;
	Session session;
	
	public boolean applyLeave(String to, String from, String reason)
	{
		int staffId = LoginService.users.getStaffId();
		String isGranted = "pending";
		boolean isApplied = false;
		LeaveRecords leaveRecords = new LeaveRecords();
		leaveRecords.setStaffId(staffId);
		leaveRecords.setToDate(to);
		leaveRecords.setFromDate(from);
		leaveRecords.setReason(reason);
		leaveRecords.setGranted(isGranted);
		
		sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		if (session.save(leaveRecords) != null) {
			isApplied = true;
		}
		
		session.getTransaction().commit();
		return isApplied;
	}
}
