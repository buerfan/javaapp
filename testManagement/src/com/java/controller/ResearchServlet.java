package com.java.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.dao.ResearchData;
import com.java.model.BookModel;
import com.java.model.ResearchModel;

public class ResearchServlet extends HttpServlet {

	ResearchData researchData = new ResearchData();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Test Print....");
		RequestDispatcher rd = null;
		String action = req.getParameter("action");
		System.out.println("Action value:  "+action);
		if (action != null) {
			if (action.equals("new")) {
				ResearchModel researchModel = new ResearchModel();
				req.setAttribute("action", "new");
				req.setAttribute("researchs", researchModel);

				rd = req.getRequestDispatcher("/newresearch.jsp");
			}

			else if (action.equals("update")) {
				int id = Integer.parseInt(req.getParameter("id").toString());
				ResearchModel researchModel = new ResearchModel();

				researchModel = researchData.getResearchById(id);
				req.setAttribute("action", "update");
				req.setAttribute("researchs", researchModel);

				rd = req.getRequestDispatcher("/newresearch.jsp");
			}

			else if (action.equals("delete")) {

				int id = Integer.parseInt(req.getParameter("id").toString());
				ResearchModel researchModel = new ResearchModel();

				researchModel.setResearchid(id);
				researchData.deleteResearch(researchModel);

				List<ResearchModel> researchModel1 = researchData.getAllResearchRecords();
				req.setAttribute("researches", researchModel1);
				rd = req.getRequestDispatcher("/index.jsp");
			}

		}
		else
		{
			List<ResearchModel> researchModels=researchData.getAllResearchRecords();
			req.setAttribute("researchs", researchModels);
			rd=req.getRequestDispatcher("/index.jsp");
		}

		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = null;
		String action = req.getParameter("action").toString();

		if (action.equals("new")) {

			ResearchModel researchModel = new ResearchModel();

			researchModel.setResearchTitle(req.getParameter("researchTitle").toString());
			researchModel.setResearchDescription(req.getParameter("researchDescription").toString());
			researchModel.setResearchCitation(req.getParameter("researchCitation").toString());
			researchModel.setResearchAuthors(req.getParameter("researchAuthors").toString());
			researchModel.setPublicationYear(req.getParameter("publicationYear").toString());
			researchModel.setPublicationJournal(req.getParameter("publicationJournal").toString());
			researchModel.setResearchDomain(req.getParameter("researchDomain").toString());

			researchData.saveResearchInformation(researchModel);

			List<ResearchModel> listOfResearchModel = researchData.getAllResearchRecords();
			req.setAttribute("researchs", listOfResearchModel);
			rd = req.getRequestDispatcher("/index.jsp");
		}

		else if (action.equals("update")) {

			ResearchModel researchModel = new ResearchModel();

			researchModel.setResearchTitle(req.getParameter("researchTitle").toString());
			researchModel.setResearchDescription(req.getParameter("researchDescription").toString());
			researchModel.setResearchCitation(req.getParameter("researchCitation").toString());
			researchModel.setResearchAuthors(req.getParameter("researchAuthors").toString());
			researchModel.setPublicationYear(req.getParameter("publicationYear").toString());
			researchModel.setPublicationJournal(req.getParameter("publicationJournal").toString());
			researchModel.setResearchDomain(req.getParameter("researchDomain").toString());

			researchModel.setResearchid(Integer.parseInt(req.getParameter("researchId").toString()));
			researchData.updateResearchInformation(researchModel);

			List<ResearchModel> listOfResearchModel = researchData.getAllResearchRecords();
			req.setAttribute("researchs", listOfResearchModel);
			rd = req.getRequestDispatcher("/index.jsp");
		}

		rd.forward(req, resp);
	}
	

}
