package com.airlines.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.airlines.dbconnection.DBconfig;


@WebServlet("/fetchbooking")
public class FetchBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		int userid = (int) session.getAttribute("userid");
		
		Connection con = DBconfig.getConnection();
		if(con!=null)
		{
			String query = "select * from tickets where userid=?";
			try {
				PreparedStatement stmt = con.prepareStatement(query);
				stmt.setInt(1, userid);
				ResultSet rs = stmt.executeQuery();
				out.print("<table style='border:1px solid;'>"
						+ "<tr sytle='border:1px solid;'>"
						+ "<th>Booking Id</th>"
						+ "<th>Flight Number</th>"
						+ "<th>User Id</th>"
						+ "<th>Travel Date</th>"
						+ "<th>No. of Passengers</th>"
						+ "<th>Total Fair</th>"
						+ "<th>Source</th>"
						+ "<th>Destination</th>"
						+ "</tr>");
				while(rs.next())
				{
					out.print("<tr>"
							+"<td>"+rs.getInt(1)+"</td>"
							+"<td>"+rs.getInt(2)+"</td>"
							+"<td>"+rs.getInt(3)+"</td>"
							+"<td>"+rs.getString(4)+"</td>"
							+"<td>"+rs.getInt(5)+"</td>"
							+"<td>"+rs.getInt(6)+"</td>"
							+"<td>"+rs.getString(7)+"</td>"
							+"<td>"+rs.getString(8)+"</td>"
							+"</tr>");
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
