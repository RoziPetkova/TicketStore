package softuni.ticket.JDBC;
 
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import softuni.ticket.JDBC.interfaces.*;
import softuni.ticket.JDBC.tablesAndColumns.*;

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
	public ResultSet selectFromTable(Tables table, List<ColumnDef<?>> columns) throws SQLException {
		return jdbcManager.executeQuery(String.format(SELECT_FROM_TABLE, 
				columns.stream()
				.map(colDef -> colDef.getName())
				.collect(Collectors.joining(", ")), 
				table.name()));
	}

	@Override
	public ResultSet selectFromTableWhere(Tables table, List<ColumnDef<?>> columns, String condition) throws SQLException {
		return jdbcManager.executeQuery(String.format(SELECT_FROM_TABLE_WHERE, 
				columns == null ? 
					EVERYTHING : 
					columns.stream()
						.map(colDef -> colDef.getName())
						.collect(Collectors.joining(", ")), 
				table.name(),
				condition));
	}

	@Override
	public ResultSet selectFromTableWhere(Tables table, String condition) throws SQLException {
		return selectFromTableWhere(table, null, condition);
	}
	
	private void executePreparedStatement(String sql, Object... parameters) throws SQLException{
		PreparedStatement prpStmt = jdbcManager.prepareStatement(sql);
		IntStream.range(0, parameters.length).forEach(idx -> {
			try {
				if(parameters[idx] instanceof String)
					prpStmt.setString(idx + 1, (String) parameters[idx]);
				if(parameters[idx] instanceof Date)
					prpStmt.setDate(idx + 1, (Date) parameters[idx]);
				if(parameters[idx] instanceof BigDecimal)
					prpStmt.setBigDecimal(idx + 1, (BigDecimal) parameters[idx]);
				if(parameters[idx] instanceof Integer)
					prpStmt.setInt(idx + 1, (Integer) parameters[idx]);
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
		});

		prpStmt.executeUpdate();
	}

	private void executeInsert(String tableName, List<String> colNames, Object... parameters) throws SQLException {
		String sql = String.format(INSERT_INTO,
			tableName,
			colNames.stream()
				.collect(Collectors.joining(", ")),
			Stream.of(parameters)
				.map(param -> "?")
				.collect(Collectors.joining(", ")));

		executePreparedStatement(sql, parameters);
	}

	@Override
	public void insertUser(String username, String password) throws SQLException {
		executeInsert(
			Tables.Users.name(),
			Arrays.asList(Columns.USER_NAME.getName(), Columns.PASSWORD.getName()),
			username,
			password);
	}

	@Override
	public void insertTicket(String ticketName, String loation, java.util.Date date, int amound, String information, BigDecimal price) throws SQLException {
		executeInsert(Tables.Tickets.name(), 
					Arrays.asList(Columns.TICKET_NAME.getName(), 
							  Columns.LOCATION.getName(),
							  Columns.EVENT_DATE.getName(),
							  Columns.AMOUNT.getName(),
							  Columns.INFORMATION.getName(),
							  Columns.TICKET_PRICE.getName()),
					ticketName, loation, date, amound, information, price);
	}
}
