package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteServlet")
public class DeleteServlet  extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		resp.setContentType("text/html");
		PrintWriter out =resp.getWriter();
		String sid=req.getParameter("id");  
	        int id=Integer.parseInt(sid); 
	        System.out.println(id);
	        
	        EmpDao.delete(id);  
	        out.println("<a href=servlet.html>Add New Employee</a><br>");
	    
	      
	        
	}
	
	

}
