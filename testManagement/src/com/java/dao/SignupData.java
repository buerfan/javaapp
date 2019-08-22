package com.java.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.java.model.BookModel;
import com.java.model.SignupModel;

public class SignupData {

	public void save(SignupModel signupModel) {
		Connection con = new Connection();

		Session session = con.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();
		session.save(signupModel);
		transaction.commit();
		System.out.println("Inserted...");
	}

	public SignupModel getPasswordByEmail(String email) {
		String query = "from SignupModel signup where signup.email='"+email+"'";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		//Query queryExecuteable = session.createQuery(query);
		Query queryExecuteable = session.createQuery(query);
		SignupModel signupModel = null;
		try {
			signupModel = (SignupModel) queryExecuteable.list().get(0);
		} catch (Exception e) {
			System.out.println("Problem with login...");
		}
		//SignupModel signupModel = (SignupModel) queryExecuteable.list().get(0);
		System.out.println(signupModel);
		return signupModel;
	}
	
	
	

}
