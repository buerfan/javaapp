package com.java.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.TimeZone;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.dao.SignupData;
import com.java.model.SignupModel;

public class AuthenticationServlet extends HttpServlet {
	
	SignupData signUpData=new SignupData();
	
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
		else if(event.equals("login"))
		{
			
			System.out.println("In login Method.. Authenticaion model...");
			SignupModel signupModel=new SignupModel();
			req.setAttribute("login", signupModel);
			req.setAttribute("event", "login");
			rd=req.getRequestDispatcher("/login.jsp");
		}
		else if(event.equals("logout"))
		{
			
			HttpSession session=req.getSession();
			session.removeAttribute("message");
			rd=req.getRequestDispatcher("/home.jsp");
		}
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd=null;
		String event=req.getParameter("event").toString();
		System.out.println("Value of Event: "+event);
		if(event.equals("register"))
		{
			SignupModel signupModel=new SignupModel();
			
			signupModel.setEmail(req.getParameter("email").toString());
			signupModel.setFirstName(req.getParameter("firstName").toString());
			signupModel.setLastName(req.getParameter("lastName").toString());
			signupModel.setPassword(req.getParameter("password").toString());
			signupModel.setRetypePassword(req.getParameter("retype_pass").toString());
			signupModel.setSex(req.getParameter("sex").toString());
			
			SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-mm-dd");
			String date=req.getParameter("datetime").toString();
			
			try {
				signupModel.setDateOfBirth(simpleDateFormat.parse(date));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			signUpData.save(signupModel);
			System.out.println("Register...in post method...");
			
		}
		else if(event.equals("login"))
		{
			String email=req.getParameter("login_id").toString();
			String password=req.getParameter("login_password").toString();
			
			SignupModel signupModel=signUpData.getPasswordByEmail(email);
			
			if(signupModel==null)
			{
				req.setAttribute("message", "Account is Invalid...");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
			else if(email.equals(signupModel.getEmail()) && password.equals(signupModel.getPassword()))
			{
				HttpSession session=req.getSession();
				session.setAttribute("message", "welcome "+signupModel.getEmail());
				req.getRequestDispatcher("home.jsp").forward(req, resp);
			}
			
		 	//System.out.println(signupModel.getEmail()+" "+signupModel.getPassword());
		}
		
	}

}
