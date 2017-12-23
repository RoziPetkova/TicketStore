package softuni.ticket.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import softuni.ticket.JDBC.interfaces.JDBCManager;

public class JDBCManagerImpl implements JDBCManager {

	private static JDBCManager instance = null;
	private Connection myConnection;
	private Statement stmn;

	private JDBCManagerImpl() {
		try {
			myConnection = DriverManager.getConnection("jdbc:h2:~/h2Database/testDB");
		} catch (SQLException e) {
			e.printStackTrace();
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

	public List<String> getAllTables() {
		
		List<String> tables = new ArrayList<String>();
		try {
			stmn = myConnection.createStatement();
			ResultSet query = stmn.executeQuery("SELECT TABLE_NAME FROM INFORMATION_SCHEMA");
			
			while (query.next()) {
				tables.add(query.getString("TABLE_NAME"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tables;
	}
}
