package com.simplilearn;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


@WebServlet("/save")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
	    String price=request.getParameter("price");
		SessionFactory factory= HibernateUtil.getSessionFactory();
		Session session=factory.openSession();		
		Transaction tx= session.beginTransaction();
		Product pro= new Product();
		float r=Float.parseFloat(price);
		pro.setName(name);
	    pro.setPrice(r);
	    session.save(pro);
		tx.commit();
		session.close();
		response.getWriter().print("Data Inserted");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
