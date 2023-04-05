package com.servlet;

import java.io.IOException;


import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetSingle_User")
public class GetSingle_User extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out =resp.getWriter();
		
		
		
		out.print("<form action=GetSingle_User method=post >");
		out.println("id<input type=text  name=id><br>");
		out.println("<input type = submit  value=find>");
		out.println("</form>"); 
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out =resp.getWriter();
		
		String sid = req.getParameter("id");
		int id = Integer.parseInt(sid);
		ResultSet rs = EmpDao.GetSingle_User(id);
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<a href=servlet.html> add new emp</a><br>");
		
		out.println("<table border='1' width='50%'");  
		out.println("<tr><th>Id</th><th>Name</th><th>Email</th><th>Password</th></tr>");
			
		try {
			while(rs.next()) {
				out.println("<tr><th>"+rs.getInt(1)+"</th>");
				out.println("<th>"+rs.getString(2)+"</th>");
				out.println("<th>"+rs.getString(3)+"</th>");
				out.println("<th>"+rs.getString(4)+"</th></tr>");
			}
			
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

}
