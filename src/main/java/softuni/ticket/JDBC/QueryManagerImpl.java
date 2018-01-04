package softuni.ticket.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import softuni.ticket.JDBC.interfaces.JDBCManager;
import softuni.ticket.JDBC.interfaces.QueryManager;
import softuni.ticket.JDBC.tablesAndColumns.Columns;

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
	public ResultSet selectFromTable(String tableName) throws SQLException {
		return jdbcManager.executeQuery(String.format(SELECT_FROM_TABLE, EVERYTHING, tableName));
	}

	@Override
	public ResultSet selectFromTable(String tableName, List<Columns> columns) throws SQLException {
		return jdbcManager.executeQuery(String.format(SELECT_FROM_TABLE, 
				columns
				.stream()
				.map(colDef -> colDef.name())
				.collect(Collectors.joining(", ")), tableName));
	}

	@Override
	public ResultSet selectFromTableWhere(String tableName, String condition) throws SQLException {
		return jdbcManager.executeQuery(String.format(SELECT_FROM_TABLE_WHERE, tableName, condition));
	}

	@Override
	public void insertUser(String tableName, List<Columns> columnsNames, List<String> parameters) throws SQLException {
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
		jdbcManager.executeDDL(String.format(INSERT_INTO, tableName));
	}

	@Override
	public void insertTicket(String tableName, List<String> columnsNames, List<String> parameters) throws SQLException {
		// TODO Auto-generated method stub
	}

}
