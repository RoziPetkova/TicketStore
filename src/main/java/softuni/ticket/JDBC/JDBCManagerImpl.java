package softuni.ticket.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import softuni.ticket.JDBC.interfaces.JDBCManager;

public class JDBCManagerImpl implements JDBCManager {
	private static JDBCManager instance;
	private Connection myConnection;
	private Statement stmn;

	private JDBCManagerImpl() {
		try {
			myConnection = DriverManager.getConnection("jdbc:h2:~/h2Database/testDB");
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	public static JDBCManager getInstance() {
		if (instance == null) {
			instance = new JDBCManagerImpl();
		}

		return instance;
	}

	public ResultSet executeQuery(String sql) throws SQLException {
		stmn = myConnection.createStatement();
		return stmn.executeQuery(sql);
	}

	public void executeDDL(String sql) throws SQLException {
		stmn = myConnection.createStatement();
		stmn.executeUpdate(sql);
	}
}
