package com.phase2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProductDetails")
public class ProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String productSearch = request.getParameter("search");
		Properties props= new Properties();
		props.load(getServletContext().getResourceAsStream
				("/WEB-INF/config.properties"));
		
		
	try {
			ProductConfig obj = new ProductConfig(props.getProperty("driver"),
					props.getProperty("url"), props.getProperty("username"),
					props.getProperty("password"));
			Connection conn=obj.getConnection();
			Statement stmt =conn.createStatement();
			//ResultSet result =stmt.executeQuery("select * from eproduct");

            
    	String sql_res= "select * from eproduct where id=" + productSearch;
        ResultSet inTable = stmt.executeQuery(sql_res);
        if(productSearch!=null)
        {        if(inTable.next())
        {out.println("<h1>"+inTable.getString("name")+" Details</h1><hr><br><br><br>");
        	out.println("ID :"+inTable.getInt("ID") + "<br>Name: " + inTable.getString("name") + "<br>Price: " + inTable.getBigDecimal("price") +"<br>Date & Time :"+inTable.getTimestamp("date_added") +"<Br>");
        }
        else
        	out.println("<h3>There is no element with product ID: " + productSearch + " in the table, please try again</h3>");
       
        }
	
	    stmt.close();
	    ((ProductConfig) conn).closeConnection();
			 
		} catch (ClassNotFoundException e) {
		    e.printStackTrace();
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
