package softuni.ticket;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

public class Main {
	//resources
	public static void main(String[] args) throws Exception {
		initialize();
	}

	public static void initialize() throws SQLException {
		Server server = new Server(8080);

		// The ServletHandler is a dead simple way to create a context handler

		// that is backed by an instance of a Servlet.
		// This handler then needs to be registered with the Server object.
		ServletHandler handler = new ServletHandler();
		server.setHandler(handler);

		// Passing in the class for the Servlet allows jetty to instantiate an

		// instance of that Servlet and mount it on a given context path.
		handler.addServletWithMapping(TestServlet.class, "/testServlet");
		handler.addServletWithMapping(TestRozi2.class, "/rozi");
		handler.addServletWithMapping(TestDataBase.class, "/dataBase");

		Connection createDBConnection = null;
		try {
			createDBConnection = DriverManager.getConnection("jdbc:h2:~/h2Database/testDB");
			recreateSchema(createDBConnection);
			TestDataBase.setMyConnection(createDBConnection());
			// Start things up!
			server.start();

			// The use of server.join() the will make the current thread join
			// and
			// wait until the server is done executing.
			// See
			// http://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html#join()
			server.join();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		finally {
			System.exit(0);
			createDBConnection.close();
		}
	}

	public static Connection createDBConnection() {
		try {
			Class.forName("org.h2.Driver");
			Connection conn = DriverManager.getConnection("jdbc:h2:~/h2Database/testDB");
			return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	private static void recreateSchema(Connection myConnection) throws SQLException {
		Statement stmn = myConnection.createStatement();
		String sql = "CREATE TABLE IF NOT EXISTS TEST(ID INT PRIMARY KEY, NAME VARCHAR(255))";
		stmn.executeUpdate(sql);
	}

	private static void createTable(Connection myConnection) throws SQLException {
		Statement stmn = myConnection.createStatement();
		String sql = "CREATE TABLE REGISTRATION (id INTEGER not NULL, first VARCHAR)";
		stmn.executeUpdate(sql);
	}
}
