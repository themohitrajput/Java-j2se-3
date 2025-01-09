package com.airlines.services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airlines.dbconnection.DBconfig;
import com.airlines.entity.Flight;

@WebServlet("/getFlight")
public class GetFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int fno = Integer.parseInt(request.getParameter("fid"));
		
		Connection con = DBconfig.getConnection();
		if(con!=null)
		{
			String query = "select * from flights where flight_number=?";
			try {
				PreparedStatement stmt = con.prepareStatement(query);
				stmt.setInt(1, fno);
				ResultSet rs = stmt.executeQuery();
				Flight flight = new Flight();
				if(rs.next())
				{
					flight.setFid(rs.getInt(1));
					flight.setAirline(rs.getString(2));
					flight.setWeeks(rs.getString(3));
					flight.setSrc(rs.getString(4));
					flight.setDest(rs.getString(5));
					flight.setPrice(rs.getInt(6));
				}
				request.setAttribute("flight", flight);
				RequestDispatcher reqDispatcher = request.getRequestDispatcher("updateFlight.jsp");
				reqDispatcher.forward(request, response);
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
