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
import javax.servlet.http.HttpSession;

import com.airlines.dbconnection.DBconfig;

@WebServlet("/ticket")
public class TicketBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int fno = (int) session.getAttribute("fno");
		int userid =  (int) session.getAttribute("userid");
		String date = (String) session.getAttribute("date");
		int passengers = (int) session.getAttribute("passengers");
		int totalFair = (int) session.getAttribute("totalAmount");
		String src = (String) session.getAttribute("src");
		String dest = (String) session.getAttribute("dest");
		
		Connection con = DBconfig.getConnection();
		if(con!=null)
		{
			String query = "insert into tickets (flight_number,userid,travel_date,passengers,totalFair,src,dest) values (?,?,?,?,?,?,?)";
			try {
				PreparedStatement stmt = con.prepareStatement(query);
				stmt.setInt(1, fno);
				stmt.setInt(2, userid);
				stmt.setString(3, date);
				stmt.setInt(4, passengers);
				stmt.setInt(5, totalFair);
				stmt.setString(6, src);
				stmt.setString(7, dest);
				stmt.executeUpdate();
				System.out.println("Executed Successfully");
				response.sendRedirect("userPage.jsp");
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
