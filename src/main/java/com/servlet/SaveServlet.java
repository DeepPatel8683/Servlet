package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/app")
public class SaveServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String name = req.getParameter("name1");
		String email = req.getParameter("email1");
		String pass = req.getParameter("password");
		
		
		Emp e = new Emp();
		e.setName(name);
		e.setEmail(email);
		e.setPassword(pass); 
		
//		System.out.println(name);
//		System.out.println(email);
//		System.out.println(pass);

		 int status=EmpDao.save(e);
		 
		 if (status>0) {
			 
			 out.print("Record saved successfully!"); 
		 }else{  
	            out.println("Sorry! unable to save record");  
	        }  
		 
		 out.close();
		
		
		
	
	}

	
	
	
	
}
