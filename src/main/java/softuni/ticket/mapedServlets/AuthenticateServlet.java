package softuni.ticket.mapedServlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import softuni.ticket.JDBC.QueryManagerImpl;
import softuni.ticket.JDBC.interfaces.QueryManager;
import softuni.ticket.JDBC.tablesAndColumns.Columns;
import softuni.ticket.JDBC.tablesAndColumns.Tables;

public class AuthenticateServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String USER = "user";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user = req.getParameter("username");
		String pass = req.getParameter("password");

		QueryManager queryManager = new QueryManagerImpl();
		ResultSet results;
		try {
			results = queryManager.selectFromTableWhere(Tables.Users, 
											Arrays.asList(Columns.USER_NAME, Columns.PASSWORD),
											String.format("USER_NAME = '%s'", user));

			// select pass user ...
			if (user != null && pass != null && !user.equals(results.getString("USER_NAME"))
					&& pass.equals(results.getString("PASSWORD"))) {
				HttpSession session = req.getSession(true);
				session.setAttribute(USER, user);

				resp.getWriter().write("<html> user authenticated </html>");
			}else 
				resp.getWriter().write("<html>Wrong user name or password!</html>");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}