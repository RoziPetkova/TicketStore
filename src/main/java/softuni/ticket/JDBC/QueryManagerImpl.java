package softuni.ticket.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import softuni.ticket.JDBC.interfaces.JDBCManager;
import softuni.ticket.JDBC.interfaces.QueryManager;
import softuni.ticket.JDBC.tablesAndColumns.Columns;
import softuni.ticket.JDBC.tablesAndColumns.Tables;

public class QueryManagerImpl implements QueryManager {
	private final static String SELECT_FROM_TABLE = "SELECT %s FROM %s ";
	private final static String SELECT_FROM_TABLE_WHERE = SELECT_FROM_TABLE + "WHERE %s";
	private final static String EVERYTHING = "*";
	private final static String INSERT_INTO = "INSERT INTO %s (%s) VALUES (%s)";
	
	private JDBCManager jdbcManager;

	public QueryManagerImpl() {
		jdbcManager = JDBCManagerImpl.getInstance();
	}

	@Override
	public ResultSet selectFromTable(Tables table) throws SQLException {
		return jdbcManager.executeQuery(String.format(SELECT_FROM_TABLE, EVERYTHING, table.name()));
	}

	@Override
	public ResultSet selectFromTable(Tables table, List<Columns> columns) throws SQLException {
		return jdbcManager.executeQuery(String.format(SELECT_FROM_TABLE, 
				columns
				.stream()
				.map(colDef -> colDef.name())
				.collect(Collectors.joining(", ")), 
				table.name()));
	}

	@Override
	public ResultSet selectFromTableWhere(Tables table, List<Columns> columns, String condition) throws SQLException {
		return jdbcManager.executeQuery(String.format(SELECT_FROM_TABLE_WHERE, 
				columns
				.stream()
				.map(colDef -> colDef.name())
				.collect(Collectors.joining(", ")), 
				table.name(), 
				condition));
	}

	@Override
	public void insertUser(Tables table, List<Columns> columnsNames, List<String> parameters) throws SQLException {
//		String sql = String.format("INSERT INTO %s"
//				+ " VALUES (1, '%s', '%s')", Tables.Users.name(), 
//				columns
//				.stream()
//				.map(colDef -> colDef.name())
//				.collect(Collectors.joining(", ")),
//				,
//				parameters
//				.stream()
//				.collect(Col));
//		
		jdbcManager.executeDDL(String.format(INSERT_INTO, table.name()));
	}

	@Override
	public void insertTicket(Tables table, List<String> columnsNames, List<String> parameters) throws SQLException {
		// TODO Auto-generated method stub
	}

}
