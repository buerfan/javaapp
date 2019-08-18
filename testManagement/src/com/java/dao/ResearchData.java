package com.java.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.java.model.BookModel;
import com.java.model.ResearchModel;

public class ResearchData {

	public void saveResearchInformation(ResearchModel researchModel) {
		Connection con = new Connection();

		Session session = con.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();
		session.save(researchModel);
		transaction.commit();
		System.out.println("Inserted...");
	}

	public List<ResearchModel> getAllResearchRecords() {
		List<ResearchModel> researchModel=new ArrayList<>();
		String query = "from ResearchModel research";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery("from ResearchModel research");
		researchModel=queryExecuteable.list();
		return researchModel;
	}

	public ResearchModel getResearchById(int id) {
		String query = "from ResearchModel research where research.id="+id;
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery(query);
		ResearchModel researchModel = (ResearchModel) queryExecuteable.list().get(0);

		return researchModel;
	}

	public void updateResearchInformation(ResearchModel researchModel) {
		Connection con = new Connection();

		Session session = con.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();
		session.update(researchModel);
		transaction.commit();
		System.out.println("Updated...");
	}

	public void deleteResearch(ResearchModel researchModel) {
		Connection con = new Connection();

		Session session = con.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();
		session.delete(researchModel);
		transaction.commit();
		System.out.println("Deleted...");
	}
	
	

}
