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

/**
 * Servlet implementation class SearchStudentByNameServlet
 */
@WebServlet("/SearchStudentByNameServlet")
public class SearchStudentByNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			PreparedStatement statement = MySQLCon.getConnection().prepareStatement(Queries.getQueryForSearchStudentByName());
			statement.setString(1, request.getParameter("first_name"));
			statement.setString(2, request.getParameter("last_name"));
			ResultSet resultSet = statement.executeQuery();
			PrintWriter out = response.getWriter();
			out.print("<html><head><title>List of Students</title></head><body align='center'>");
			out.print("<table border = '1'>");
			out.print("<tr><th>Email</th><th>FirstName</th><th>LastName</th><th>Father'sName</th><th>Class</th><th>Age</th></tr>");
			while (resultSet.next()) {
				out.print("<tr><td> " + resultSet.getString(1) + " </td> " + "<td> " + resultSet.getString(2) + " </td>");
				out.print("<td> " + resultSet.getString(3) + " </td> " + "<td> " + resultSet.getString(4) + " </td>");
				out.print("<td> " + resultSet.getString(5) + " </td> " + "<td> " + resultSet.getString(6) + " </td></tr>");
			}
			out.print("</table></body></html>");
			out.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
