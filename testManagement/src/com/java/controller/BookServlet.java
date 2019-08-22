package com.java.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.dao.DBData;
import com.java.dao.ResearchData;
import com.java.model.BookModel;
import com.java.model.ResearchModel;

public class BookServlet extends HttpServlet {

	DBData db = new DBData();
	ResearchData researchData=new ResearchData();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher rd = null;
		String action = req.getParameter("action");

		System.out.println("Value of Action" + action);
		System.out.println(action);
		if (action != null) {
			if (action.equals("new")) {

				BookModel bookModel = new BookModel();
				req.setAttribute("books", bookModel);
				req.setAttribute("action", "new");

				rd = req.getRequestDispatcher("/newbook.jsp");
				System.out.println("In New Page...");
			}

			else if (action.equals("update")) {
				int id = Integer.parseInt(req.getParameter("id").toString());
				BookModel bookModel = db.getBookById(id);
				req.setAttribute("books", bookModel);
				req.setAttribute("action", "update");
				rd = req.getRequestDispatcher("/newbook.jsp");

			}
			else if(action.equals("delete"))
			{
				int id = Integer.parseInt(req.getParameter("id").toString());
				BookModel bookModel = new BookModel();
				bookModel.setId(id);
				db.deleteBook(bookModel);
				List<BookModel> bookModel1 = db.getAllBooks();
				req.setAttribute("books", bookModel1);
				rd = req.getRequestDispatcher("/index.jsp");
			}
			
		} else {

			System.out.println("action line 49 servlet " + action);
			List<BookModel> bookModel = db.getAllBooks();
			List<ResearchModel> researchModels=researchData.getAllResearchRecords();
			req.setAttribute("books", bookModel);
			req.setAttribute("researchs", researchModels);
			rd = req.getRequestDispatcher("/index.jsp");
		}

		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = null;
		String action = req.getParameter("action").toString();

		if (action.equals("new")) {
			BookModel book = new BookModel();

			book.setTitle(req.getParameter("title").toString());
			book.setAuthor(req.getParameter("author").toString());
			book.setPrice(Float.parseFloat(req.getParameter("price")));

			db.saveBook(book);

			List<BookModel> bookModels = db.getAllBooks();
			req.setAttribute("books", bookModels);
			rd = req.getRequestDispatcher("/index.jsp");
		}
		
		else if(action.equals("update"))
		{
			BookModel book=new BookModel();
			book.setTitle(req.getParameter("title").toString());
			book.setAuthor(req.getParameter("author").toString());
			book.setPrice(Float.parseFloat(req.getParameter("price")));

			book.setId(Integer.parseInt(req.getParameter("bookId").toString()));
			
			db.updateBook(book);
			
			List<BookModel> bookModels = db.getAllBooks();
			req.setAttribute("books", bookModels);
			rd = req.getRequestDispatcher("/index.jsp");
		}

		rd.forward(req, resp);
	}
}
