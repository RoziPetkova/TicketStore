package softuni.ticket.mapedServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import softuni.ticket.JDBC.JDBCManagerImpl;
import softuni.ticket.JDBC.TablesManagerImpl;
import softuni.ticket.JDBC.interfaces.TablesManager;
import softuni.ticket.JDBC.tavlesAndColumns.Tables;

public class SignNewUser extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String x = req.getParameter("userName");
		String y = req.getParameter("password");
		String sql = String.format("INSERT INTO %s"
				+ " VALUES (1, '%s', '%s')", Tables.Users.name(), x, y);
		try {
			JDBCManagerImpl.getInstance().executeDDL(sql);
			PrintWriter writer = resp.getWriter();
			
			writer.write(String.format("<html> Hello user %s! </html>", x));
		} catch (SQLException e) {
			e.printStackTrace();
			resp.getWriter().write("Something went wrong:");
		}
	}
}
