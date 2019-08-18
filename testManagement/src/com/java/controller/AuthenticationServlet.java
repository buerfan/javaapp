package com.java.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.TimeZone;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.model.SignupModel;

public class AuthenticationServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher rd=null;
		String event=req.getParameter("event");
		
		if(event.equals("register"))
		{
			System.out.println("Register...");
			SignupModel signupModel=new SignupModel();
			req.setAttribute("registers", signupModel);
			req.setAttribute("event", "register");
			rd=req.getRequestDispatcher("/register.jsp");
			
		}
		
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd=null;
		String event=req.getParameter("event");
		
		if(event.equals("register"))
		{
			SignupModel signupModel=new SignupModel();
			
			signupModel.setEmail(req.getParameter("email").toString());
			signupModel.setFirstName(req.getParameter("firstName").toString());
			signupModel.setFirstName(req.getParameter("lastName").toString());
			signupModel.setPassword(req.getParameter("password").toString());
			signupModel.setPassword(req.getParameter("retype_pass").toString());
			signupModel.setSex(req.getParameter("sex").toString());
			
			
			//signupModel.setDateOfBirth(date);
			
			System.out.println("Register...in post method...");
			
		}
		
	}

}
