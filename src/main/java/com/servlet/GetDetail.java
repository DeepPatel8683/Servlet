package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetDetail")
public class GetDetail extends HttpServlet {
	
	
	
	private static final long serialversionUID =1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		  resp.setContentType("text/html");  
	        PrintWriter out=resp.getWriter(); 
	        
	        
	      
	        
	        List<Emp> list=EmpDao.GetDetail();  
	          
	        out.print("<table border='1' width='50%'");  
	        out.print("<tr><th>id</th>"
	        		+ "<th>name</th>"
	        		+ "<th>email</th>"
	        		+ "<th>password</th>"
	        		+ "<th>Delete</th>"
	        		+ "</tr>");  
	        for(Emp e:list){  
	         out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getEmail()+"</td><td>"+e.getPassword()+ "</td><td><a href=DeleteServlet?id="+e.getId()+">Delete</a></td></tr>");
	         
	        }  
	        out.print("</table>");  
	        out.print("<br>");
	        out.println("<a href='servlet.html'><Button>Get All Details</Button></a>");
	        out.close();  
	      
	        	
	}
	
}
