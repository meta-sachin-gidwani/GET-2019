package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateStudentDetailsServlet
 */
@WebServlet("/UpdateStudentDetailsServlet")
public class UpdateStudentDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out= response.getWriter();
		out.print("<html><head><title>Update Student Detail</title></head><body align='center'><form action='DetailUpdateServlet'>"
				  + "<input name='first_name' type='text' pattern='[A-Z a-z]*' value='"
				  + request.getParameter("first_name") + "'><br><br><input name='last_name' type='text' pattern='[A-Z a-z]*' value='"
				  + request.getParameter("last_name") + "'><br><br><input name='father_name' type='text' pattern='[A-Z a-z]*' value='"
				  + request.getParameter("father_name") + "'><br><br><input name='email' type='email' value='"
				  + request.getParameter("email") + "' readonly><br><br><input name='class' type='number' value='"
				  + request.getParameter("class") + "'><br><br><input name='age' type='number' value='"
				  + request.getParameter("age") + "'><br><br><input name='submitButton' type='submit' value='Update'></form></body></html>");
	}
}
