package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DetailUpdateServlet
 */
@WebServlet("/DetailUpdateServlet")
public class DetailUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			PreparedStatement statement = MySQLCon.getConnection().prepareStatement(Queries.getQueryForUpdateDetail());
			statement.setString(1, request.getParameter("first_name"));
			statement.setString(2, request.getParameter("last_name"));
			statement.setString(3, request.getParameter("father_name"));
			statement.setInt(4, Integer.parseInt(request.getParameter("class")));
			statement.setInt(5, Integer.parseInt(request.getParameter("age")));
			statement.setString(6, request.getParameter("email"));
			statement.executeUpdate();
			PrintWriter out = response.getWriter();
			out.print("successfully Updated");
			out.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
