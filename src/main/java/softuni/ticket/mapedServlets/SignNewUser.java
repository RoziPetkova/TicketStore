package softuni.ticket.mapedServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import softuni.ticket.Utils;
import softuni.ticket.JDBC.JDBCManagerImpl;
import softuni.ticket.JDBC.tablesAndColumns.Tables;

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
		PrintWriter writer = resp.getWriter();

		String sql = String.format("INSERT INTO %s" 
								+ " VALUES (1, '%s', '%s')", 
								Tables.Users.name(), x, y);

		try {
			JDBCManagerImpl.getInstance().executeDDL(sql);

			writer.write(Utils.jsonSerialize(String.format("Hello user %s!", x)));
		} catch (SQLException e) {
			e.printStackTrace();
			writer.write(Utils.jsonSerialize("Something went wrong:"));
		}
	}
}
