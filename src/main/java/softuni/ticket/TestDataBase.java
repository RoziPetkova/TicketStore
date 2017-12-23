package softuni.ticket;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestDataBase extends HttpServlet {

	private static Connection myConnection;
	
	private static final long serialVersionUID = 1L;
	
	public static void setMyConnection(Connection connection) {
		myConnection = connection;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int a = Integer.valueOf(req.getParameter("a"));
		String name = req.getParameter("name");	
		Statement stmt;
		 
		try {
			stmt = myConnection.createStatement();
			String sql = "INSERT INTO Registration VALUES (%s, '%s')";
	      stmt.executeUpdate(String.format(sql, a, name));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
