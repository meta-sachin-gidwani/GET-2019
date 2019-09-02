package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.classes.MySQLCon;
import com.classes.Queries;

/**
 * Servlet implementation class LogInServlet
 */
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PreparedStatement statement= MySQLCon.getConnection().prepareStatement(Queries.getQueryForLogIn());
			statement.setString(1, request.getParameter("email"));
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			if(request.getParameter("password").equals(resultSet.getString(1))){
				statement = MySQLCon.getConnection().prepareStatement(Queries.getEmpId());
				statement.setString(1, request.getParameter("email"));
				ResultSet empId = statement.executeQuery();
				empId.next();
				request.setAttribute("emp_id", empId.getInt(1));
				HttpSession session = request.getSession();
				session.setAttribute("emp_id",empId.getInt(1));
				getServletContext().getRequestDispatcher("/home.jsp").include(request, response);
			}else{
				PrintWriter out = response.getWriter();
				out.print("<html><body>Invalid email or password<br><a href='login.html'>Log In</a></body></html>");
				out.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
