package com.airlines.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.airlines.dbconnection.DBconfig;

@WebServlet("/userlogin")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		
		Connection con = DBconfig.getConnection();
		if(con!=null)
		{
			String query = "select * from users";
			try {
				PreparedStatement stmt = con.prepareStatement(query);
				ResultSet rs = stmt.executeQuery();
				while(rs.next())
				{
					if(user.equals(rs.getString(2)) && password.equals(rs.getString(3)))
					{				
						session.setAttribute("userid", rs.getInt(1));
						session.setAttribute("username", rs.getString(2));
						response.sendRedirect("userPage.jsp");
					}
				}
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		PrintWriter out = response.getWriter();
		out.print("Invalid Admin Username and Password");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
