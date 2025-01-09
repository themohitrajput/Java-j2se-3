	package com.airlines.services;
	
	import java.io.IOException;
	import java.io.PrintWriter;
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
	
	@WebServlet("/changepswd")
	public class ChangePasswordServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
	
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Connection con = DBconfig.getConnection();
			HttpSession session = request.getSession();
			response.setContentType("text/html");
			int userid = (int) session.getAttribute("userid");
			String newPassword = request.getParameter("newpassword");
			if(con!=null)
			{
				String query = "update users set password=? where userid=?";
				try {
					PreparedStatement stmt = con.prepareStatement(query);
					stmt.setString(1, newPassword);
					stmt.setInt(2, userid);
					stmt.executeUpdate();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
				PrintWriter out = response.getWriter();
				out.print("Password Changed Successfully<br>");
				session.removeAttribute("userid");
				session.invalidate();
				out.print("<a href='userLogin.jsp'>Login Again</a>");
			}
		}
	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}
	
	}
