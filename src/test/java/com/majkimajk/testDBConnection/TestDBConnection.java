package com.majkimajk.testDBConnection;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestDbServlert")
public class TestDBConnection {
	

	/**
	 * Servlet implementation class TestDbServlert
	 */
	

		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public TestDBConnection() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String user = "root";
			String pass = "root";
			
			String jdbcUrl = "jdbc:mysql://localhost:3306/spring_maven_app?useSSL=false";
			String jdbcDriver = "com.mysql.jdbc.Driver";
			
			
			try{
				
				PrintWriter out = response.getWriter();
				
				out.println("connecting to database: " + jdbcUrl);
				
				Class.forName(jdbcDriver);
				
				Connection conn = DriverManager.getConnection(jdbcUrl, user, pass);
				
				out.println("Done!!");
				
				
			}
			catch(Exception e) {
				
				e.printStackTrace();
				throw new ServletException(e);
			}
		
		}

	

}
