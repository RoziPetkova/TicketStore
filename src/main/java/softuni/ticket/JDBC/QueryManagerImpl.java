package softuni.ticket.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import softuni.ticket.JDBC.interfaces.JDBCManager;
import softuni.ticket.JDBC.interfaces.QueryManager;
import softuni.ticket.JDBC.tavlesAndColumns.Columns;

public class QueryManagerImpl implements QueryManager {

	private JDBCManager jdbManager;
	private final static String SELECT_FROM_TABLE = "SELECT %s FROM %s ";
	private final static String SELECT_FROM_TABLE_WHERE = SELECT_FROM_TABLE + "WHERE %s";
	private final static String EVETITHING = "*";
	private final static String INSERT_INTO = "INSERT INTO %s (%s) "
											+ "VALUES (%s);";

	public QueryManagerImpl() {
		jdbManager = JDBCManagerImpl.getInstance();
	}

	@Override
	public ResultSet selecFromTable(String tableName) throws SQLException {
		return jdbManager.executeQuery(String.format(SELECT_FROM_TABLE, EVETITHING, tableName));
	}

	@Override
	public ResultSet selecFromTable(String tableName, List<Columns> columns) throws SQLException {
		return jdbManager.executeQuery(String.format(SELECT_FROM_TABLE, 
				columns
				.stream()
				.map(colDef -> colDef.name())
				.collect(Collectors.joining(", ")), tableName));
	}

	@Override
	public ResultSet selecFromTableWHERE(String tableName, String condition) throws SQLException {
		return jdbManager.executeQuery(String.format(SELECT_FROM_TABLE_WHERE, tableName, condition));
	}

	@Override
	public void incertUser(String tableName, List<Columns> columnsNames, List<String> parameters) throws SQLException {
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
		jdbManager.executeDDL(String.format(INSERT_INTO, tableName));
	}

	@Override
	public void incertTicket(String tableName, List<String> columnsNames, List<String> parameters) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
