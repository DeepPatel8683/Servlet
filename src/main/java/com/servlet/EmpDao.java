package com.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;


public class EmpDao {
	
	static Connection con;  
	
	 public static Connection getConnection(){  
	        
	        try{  
	            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
	            con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;Database=Servlet;encrypt=false","sa","Admin#123");  
	            return con;
	        }catch(Exception e){System.out.println(e);}  
	        return con;  
	    }  
	 
	    public static int save(Emp e){  
	        int status=0;  
	        try{  
	            Connection con=EmpDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement(  
	                         "insert into Httpservlets values(?,?,?)");
	            ps.setString(1,e.getName());  
	            ps.setString(2,e.getEmail());  
	            ps.setString(3,e.getPassword());  
	            
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }  
		
	    public static List<Emp> GetDetail(){  
	        List<Emp> list=new ArrayList<Emp>();  
	          
	        try{  
	            Connection con=EmpDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from Httpservlets");  
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
	                Emp e=new Emp();  
	                e.setId(rs.getInt(1));  
	                e.setName(rs.getString(2));  
	                e.setEmail(rs.getString(3)); 
	                e.setPassword(rs.getString(4));  
	                 
	                list.add(e);  
	            }  
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return list;  
	    }  
//	    
	    public static ResultSet GetSingle_User(int id){  
	    	 Emp e=new Emp();  
	          
	         try{  
	             Connection con=EmpDao.getConnection();  
	             PreparedStatement ps=con.prepareStatement("select * from Httpservlets where id=?");  
	             ps.setInt(1,id);  
	             ResultSet rs=ps.executeQuery();
	             
	             return rs;
	
	         }catch(Exception ex){ex.printStackTrace();}  
	           
	         return null;  
	     }  
	    
	    
	    
	    public static int delete(int id){  
	        int status=0;  
	        try{  
	            Connection con=EmpDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("delete from Httpservlets where id=?");  
	            ps.setInt(1,id);  
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception e){
	        	e.printStackTrace();
	        	}  
	          
	        return status;  
	    }  

}
