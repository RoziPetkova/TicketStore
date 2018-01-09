package softuni.ticket.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import softuni.ticket.JDBC.interfaces.JDBCManager;
import softuni.ticket.JDBC.interfaces.TablesManager;
import softuni.ticket.JDBC.tablesAndColumns.ColumnDef;
import softuni.ticket.JDBC.tablesAndColumns.Tables;

public class TablesManagerImpl implements TablesManager {
	private final static String ADD_PR_KEY = "ALTER TABLE %s ADD CONSTRAINT %s PRIMARY KEY (%s)";
	private final static String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS %s (%s)"; 
	private final static String DROP_TABLE = "DROP TABLE %s";
	
	private JDBCManager jdbcManager;

	public TablesManagerImpl() {
		jdbcManager = JDBCManagerImpl.getInstance();
	}
	
	@Override
	public void createTable(String tableName, List<ColumnDef<?>> columns) throws SQLException {
		jdbcManager.executeDDL(String.format(CREATE_TABLE, 
			tableName, 
			columns.stream()
			.map(def -> def.getName() 
					+ " " + def.getType() 
					+ " " + def.getProperties()).collect(Collectors.joining(", "))));
	}

	@Override
	public void dropTable(String tableName) throws SQLException {
		jdbcManager.executeDDL(String.format(DROP_TABLE, tableName));
	}

	@Override
	public boolean tableExists(String tableName) throws SQLException {
		return this.getAllTables().contains(tableName);
	}

	@Override
	public List<String> getAllTables() throws SQLException {
		List<String> tables = new ArrayList<String>();
		ResultSet query = jdbcManager.executeQuery("SELECT * FROM INFORMATION_SCHEMA");
		while (query.next()) {
			tables.add(query.getString(3));
		}
		return tables;
	}
	
	@Override
	public void addRimaryKey(Tables table, ColumnDef<?> col) throws SQLException {
		jdbcManager.executeDDL(String.format(ADD_PR_KEY, table.name(), col.getName()));
	}
}
