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

@WebServlet("/ProductList")

public class ProductList extends HttpServlet {
        private static final long serialVersionUID = 1L;
  
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                // TODO Auto-generated method stub
                
               
                	response.setContentType("text/html");
            		PrintWriter out = response.getWriter();
            		Properties props= new Properties();
            		props.load(getServletContext().getResourceAsStream
            				("/WEB-INF/config.properties"));
            		
            		
            	try {
            			ProductConfig obj = new ProductConfig(props.getProperty("driver"),
            					props.getProperty("url"), props.getProperty("username"),
            					props.getProperty("password"));
            			Connection conn=obj.getConnection();
            			Statement stmt =conn.createStatement();
            			ResultSet result =stmt.executeQuery("select * from eproduct");
      
                      
	                        out.println("The following are the elements in the table" + "<Br>" + "<Br>");
	                      
	                        while (result.next()) {
	                                out.println(result.getInt("ID") + ". " + result.getString("name")+ "<Br>");
	                        }
                   
                        out.println("<br>");
                        out.println("<form  action ='ProductDetails' method='post'  name='loginForm'>");
                        out.println("Enter the product id to check the product details :<br> <input type='text' name='search'/> <br/>");
                        out.println("<input type='submit' value='Submit' />");
                        out.println("</form>");
                         
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

