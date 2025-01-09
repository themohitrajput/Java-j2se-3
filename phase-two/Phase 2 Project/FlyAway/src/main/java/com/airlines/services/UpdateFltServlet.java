package com.airlines.services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airlines.dbconnection.DBconfig;

@WebServlet("/updateFlt")
public class UpdateFltServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int fno = Integer.parseInt(request.getParameter("fno"));
		String airline = request.getParameter("airline");
		String[] weekdays = request.getParameterValues("weeks");
		String weeks = String.join("_", weekdays);
		String src = request.getParameter("src");
		String dest = request.getParameter("dest");
		int price = Integer.parseInt(request.getParameter("price"));
		
		Connection con = DBconfig.getConnection();
		if(con!=null)
		{
			String query = "update flights set flight_number=?,airline=?,weekdays=?,src_airport_code=?,dest_airport_code=?,price=? where flight_number=?";
			try {
				PreparedStatement stmt = con.prepareStatement(query);
				stmt.setInt(1, fno);
				stmt.setString(2, airline);
				stmt.setString(3, weeks);
				stmt.setString(4, src);
				stmt.setString(5, dest);
				stmt.setInt(6, price);
				stmt.setInt(7, fno);
				stmt.executeUpdate();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
