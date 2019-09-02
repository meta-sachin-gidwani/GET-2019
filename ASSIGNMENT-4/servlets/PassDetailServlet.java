package com.servlets;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.classes.MySQLCon;
import com.classes.Queries;

/**
 * Servlet implementation class passDetailServlet
 */
public class PassDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PreparedStatement statement= MySQLCon.getConnection().prepareStatement(Queries.getQueryForAddPass());
			statement.setInt(1, Integer.parseInt(request.getParameter("emp_id")));
			switch (request.getParameter("typeOfCurrency")) {
				case "USD" :
					statement.setString(2, request.getParameter("final_price"));
					break;
				case "INR" :
					double INRprice=0.014*(Double.parseDouble(request.getParameter("final_price")));
					statement.setString(2, INRprice+"");
					break;
				case "YEN" :
					double YENprice=0.0094*(Double.parseDouble(request.getParameter("final_price")));
					statement.setString(2, YENprice+"");
					break;
			}
			statement.executeUpdate();
			request.setAttribute("emp_id", request.getParameter("emp_id"));
			getServletContext().getRequestDispatcher("/home.jsp").include(request, response);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}
