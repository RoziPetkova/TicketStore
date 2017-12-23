package softuni.ticket.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import softuni.ticket.JDBC.interfaces.ColumnDef;
import softuni.ticket.JDBC.interfaces.JDBCManager;
import softuni.ticket.JDBC.interfaces.TablesManager;

public class JDBCTableManagerImpl implements TablesManager {
	
	private static TablesManager instance = null;
	private JDBCManager jdbcmanager;
	private Statement stmn;

	private JDBCTableManagerImpl() {
		jdbcmanager = JDBCManagerImpl.getInstance();
	}

	public static TablesManager getInstance() {
		if (instance == null) {
			instance = new JDBCTableManagerImpl();
		}
		return instance;
	}

	
	public void createTable(String tableName, List<ColumnDef> columns) throws SQLException {
		
	}

	public void dropTable(String tableName) throws SQLException {
		
	}

}
