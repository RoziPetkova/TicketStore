package softuni.ticket.mapedServlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import softuni.ticket.JDBC.JDBCManagerImpl;
import softuni.ticket.JDBC.interfaces.JDBCManager;

//"/dataBase"
public class TestDataBase extends HttpServlet {

	private JDBCManager jdbcManager;

	private static final long serialVersionUID = 1L;

	public TestDataBase() {
		jdbcManager = JDBCManagerImpl.getInstance();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// int a = Integer.valueOf(req.getParameter("a"));
		ResultSet executeQuery = null;
		try {
			executeQuery = jdbcManager.executeQuery("SELECT * FROM TEST");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		resp.getWriter().write(executeQuery.toString());
	}
}
