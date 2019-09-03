package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowStudentsServlet
 */
@WebServlet("/ShowStudentsServlet")
public class ShowStudentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Statement statement = MySQLCon.getConnection().createStatement();
			ResultSet result = statement.executeQuery(Queries.getQueryForShowStudents());
			PrintWriter out = response.getWriter();
			out.print("<html><head><title>Students</title></head><body align='center'>");
			out.print("<table border = '1'>");
			out.print("<tr><th>Email</th><th>FirstName</th><th>LastName</th><th>Father'sName</th><th>Class</th><th>Age</th></tr>");
			while (result.next()) {
				out.print("<tr><form action = 'UpdateStudentDetailsServlet'><td>"
						+ "<input type = 'text' name='email' readonly value = '" + result.getString(1) + "' readonly> " + "</td><td>"
						+ "<input type = 'text' name='first_name' value = '" + result.getString(2) + "' readonly> " + "</td><td>"
						+ "<input type = 'text' name='last_name' value = '" + result.getString(3) + "' readonly> " + "</td><td>"
						+ "<input type = 'text' name='father_name' value = '" + result.getString(4) + "' readonly> " + "</td><td>"
						+ "<input type = 'text' name='class' value = '" + result.getString(5) + "' readonly> " + "</td><td>"
						+ "<input type = 'text' name='age' value = '" + result.getString(6) + "' readonly> " + "</td><td>"
						+ "<input type='submit' name='submitButton' value = 'update'></form></td></tr>");
			}
			out.print("</table></body></html>");
			out.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
