package com.org.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String insert = "INSERT INTO emp (name, email, phone, jobtype ,username, password) VALUES(?, ?, ?, ?, ?,?);";
		
		String FullName = request.getParameter("Name");
		String Email = request.getParameter("email");
		String Phone = request.getParameter("phone");
		String jobtype = request.getParameter("jobs");
		String username = request.getParameter("uname");
        String password = request.getParameter("upass");
        
        
        System.out.println("fullname "+FullName);
		System.out.println("email "+Email);
		System.out.println("phone "+Phone);
		System.out.println("JobType "+jobtype);
        
        
        boolean valid=false;
		System.out.println(username +"  ::  "+password);
	
		Connection con = null;
		PreparedStatement preparedStatement = null;		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver is loading...");
			
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Sahu9876@");
			System.out.println(" Connecting... to DB ");
			 preparedStatement = con.prepareStatement("INSERT INTO emp (name, email, phone, jobtype ,username, password) VALUES(?, ?, ?, ?, ?,?)");
		     preparedStatement.setString(1, FullName);
		     preparedStatement.setString(2, Email);
		     preparedStatement.setString(3, Phone);
		     preparedStatement.setString(4, jobtype);
		     preparedStatement.setString(5,username);
		     preparedStatement.setString(6, password);
		     System.out.println("insert Query exceution done!...");
		     ResultSet rs1 = preparedStatement.executeQuery();
		     
		     
		     preparedStatement = con.prepareStatement("select username, password from login.emp where username=? and password=?");
		     preparedStatement.setString(1, username);
		     preparedStatement.setString(2, password);
			System.out.println("searching username and psssword Query exceution done!...");
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()){
				valid=true;
			}
	
		}catch(ClassNotFoundException e){
			System.out.println("Driver not load "+ e.getMessage());
		}catch(SQLException e){
			System.out.println("SQL Exception "+e.getMessage());
		}
		catch(Exception e){
			
		}finally{
			if(con!=null){
				try{
					con.close(); 
				}catch(Exception e){
					System.out.println("DB connection clossing error "+e.getMessage());
				}
			}
		}
		System.out.println(" out valid= "+valid);
		
			if(valid){
				RequestDispatcher dis= request.getRequestDispatcher("loginSucc.jsp");
				dis.forward(request, response);
			}else{
				response.sendRedirect("loginErr.jsp");
			}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String prod = request.getParameter("pro");
	       
			
					
			Connection con = null;
			PreparedStatement psmt = null;		
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Driver is loading...");
				
				con =DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Sahu9876@");
				System.out.println(" Connecting... to DB ");
				
				 psmt = con.prepareStatement("select * from login.product");
				
			    //psmt.setString(1, prod);
				ResultSet rs = psmt.executeQuery();
				while(rs.next()){
					
					pw.println("Id : "+rs.getInt(1));
					pw.println("productName : "+rs.getString(2));
					
				}
		
			}catch(ClassNotFoundException e){
				System.out.println("Driver not load "+ e.getMessage());
			}catch(SQLException e){
				System.out.println(" SQL Exception "+e.getMessage());
			}
			catch(Exception e){
				
			}finally{
				if(con!=null){
					try{
						con.close(); 
					}catch(Exception e){
						System.out.println("Exception is "+e.getMessage());
					}
				}
			}
			System.out.println(" excuting.... ");
			
		
		
	}

}