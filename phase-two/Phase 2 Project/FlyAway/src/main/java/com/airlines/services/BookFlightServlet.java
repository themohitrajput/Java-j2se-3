package com.airlines.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/book")
public class BookFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int fno = Integer.parseInt(request.getParameter("id"));
		String airline = request.getParameter("airline");
		String date = request.getParameter("date");
		String src = request.getParameter("src");
		String dest = request.getParameter("dest");
		int price = Integer.parseInt(request.getParameter("price"));
		int totalCost = Integer.parseInt(request.getParameter("totalcost"));
		int passengers = Integer.parseInt(request.getParameter("passengers"));
		HttpSession session = request.getSession();
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("Flight Number : "+fno+"<br>");
		out.println("Airline : "+airline+"<br>");
		out.println("Date of Journey : "+date+"<br>");
		out.println("Source Airport Code : "+src+"<br>");
		out.println("Destination Airport Code : "+dest+"<br>");
		out.println("Price of Ticket : "+price+"<br>");
		out.println("Number of Passengers : "+passengers+"<br>");
		out.println("Total Amount to be Paid : "+totalCost+"<br>");
		session.setAttribute("totalAmount", totalCost);
		session.setAttribute("src", src);
		session.setAttribute("dest", dest);
		session.setAttribute("airline", airline);
		session.setAttribute("passengers", passengers);
		session.setAttribute("fno", fno);
		out.println("<a href='pay.jsp'>Confirm and Pay</a>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
