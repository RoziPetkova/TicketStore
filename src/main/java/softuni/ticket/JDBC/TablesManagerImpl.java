package softuni.ticket.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import softuni.ticket.JDBC.interfaces.JDBCManager;
import softuni.ticket.JDBC.interfaces.TablesManager;
import softuni.ticket.JDBC.tavlesAndColumns.ColumnDef;

public class TablesManagerImpl implements TablesManager {
	private JDBCManager jdbcManager;

	public TablesManagerImpl() {
		jdbcManager = JDBCManagerImpl.getInstance();
	}

	@Override
	public void createTable(String tableName, List<ColumnDef> columns) throws SQLException {
		jdbcManager.executeDDL(String.format("CREATE TABLE IF NOT EXISTS %s (%s)", 
			tableName, 
			columns.stream()
				.map(colDef -> colDef.getName() + " " + colDef.getType())
				.collect(Collectors.joining(", "))));
	}

	@Override
	public void dropTable(String tableName) throws SQLException {
		jdbcManager.executeDDL(String.format("DROP TABLE %s", tableName));
	}

	@Override
	public boolean tableExists(String tableName) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public List<String> getAllTables() throws SQLException {
		List<String> tables = new ArrayList<String>();
		ResultSet query = jdbcManager.executeQuery("SELECT TABLE_NAME FROM INFORMATION_SCHEMA");
		while (query.next()) {
			tables.add(query.getString("TABLE_NAME"));
		}
	
		return tables;
	}
}
