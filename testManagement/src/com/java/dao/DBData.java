package com.java.dao;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.java.model.BookModel;

public class DBData {

	public void saveBook(BookModel book) {

		Connection con = new Connection();

		Session session = con.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();
		session.save(book);
		transaction.commit();
		System.out.println("Inserted...");

	}

	public BookModel getBookById(int id) {
		String query = "from BookModel book where book.id="+id;
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery(query);
		BookModel bookModel = (BookModel) queryExecuteable.list().get(0);

		return bookModel;

	}

	public List<BookModel> getAllBooks() {
		List<BookModel> bookModel=new ArrayList<>();
		String query = "from BookModel book";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery("from BookModel book");
		bookModel=queryExecuteable.list();
		return bookModel;
	}
	
	public List<BookModel> getAllBookModels()
	{
		List<BookModel> bookModel=new ArrayList<>();
		
		Connection con=new Connection();
		Session session=con.getSessionFactory().openSession();
		
		Query query=session.createQuery("from BookModel book");
		System.out.println("line 59 dbdata  "+query);
		bookModel=query.list();
		
		return bookModel;
	}

	public void updateBook(BookModel book) {
		Connection con = new Connection();

		Session session = con.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();
		session.update(book);
		transaction.commit();
		System.out.println("Updated...");
	}

	public void deleteBook(BookModel bookModel) {
		
		Connection con = new Connection();

		Session session = con.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();
		session.delete(bookModel);
		transaction.commit();
		System.out.println("Deleted...");
	}

}
