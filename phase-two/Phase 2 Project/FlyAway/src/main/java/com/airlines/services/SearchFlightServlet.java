package com.airlines.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.airlines.dbconnection.DBconfig;
import com.airlines.entity.Flight;

@WebServlet("/searchFlight")
public class SearchFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String fromLoc = request.getParameter("fromLocation");
		String toLoc = request.getParameter("toLocation");
		String date = request.getParameter("travelDate");
		session.setAttribute("date", date);
		int passengers = Integer.parseInt(request.getParameter("passengers"));
		String day;
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		Connection con = DBconfig.getConnection();
		if(con!=null)
		{
			String query = "select * from flights where src_airport_code=? and dest_airport_code=?";
			try {
				Date date1=new SimpleDateFormat("dd-MM-yyyy").parse(date);
		        day = new SimpleDateFormat("EE").format(date1);
				PreparedStatement stmt = con.prepareStatement(query);
				stmt.setString(1, fromLoc);
				stmt.setString(2, toLoc);
				ResultSet rs = stmt.executeQuery();
				out.print("<table style='border:1px solid;'>"
						+ "<tr sytle='border:1px solid;'>"
						+ "<th>Flight Number</th>"
						+ "<th>Airline</th>"
						+ "<th>Date of Journey</th>"
						+ "<th>Source Airport Code</th>"
						+ "<th>Destination Airport Code</th>"
						+ "<th>Price Per Person</th>"
						+ "<th>Total Passengers</th>"
						+ "<th>Total Cost</th>"
						+ "<th>Booking</th>"
						+ "</tr>");
				while(rs.next())
				{
					String[] weeks = rs.getString(3).split("_");
					for(String week : weeks)
					{
						if(week.equals(day))
						{
							out.print("<tr>"
									+"<td>"+rs.getInt(1)+"</td>"
									+"<td>"+rs.getString(2)+"</td>"
									+"<td>"+date+"</td>"
									+"<td>"+rs.getString(4)+"</td>"
									+"<td>"+rs.getString(5)+"</td>"
									+"<td>"+rs.getInt(6)+"</td>"
									+"<td>"+passengers+"</td>"
									+"<td>"+(rs.getInt(6)*passengers)+"</td>"
									+"<td><a href='book?id="+rs.getInt(1)+"&date="+date+"&passengers="+passengers+"&totalcost="+(rs.getInt(6)*passengers)+"&airline="+rs.getString(2)+"&src="+rs.getString(4)+"&dest="+rs.getString(5)+"&price="+rs.getInt(6)+"'>Book</a></td>"
									+"</tr>");
						}
					}
				}
				out.print("</table>");
				
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
