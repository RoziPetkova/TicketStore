package softuni.ticket.JDBC.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import softuni.ticket.JDBC.tavlesAndColumns.Columns;

public interface QueryManager {

	public ResultSet selecFromTable(String tableNAme) throws SQLException;
	public ResultSet selecFromTable(String tableName, List<Columns> columns) throws SQLException;
	public ResultSet selecFromTableWHERE(String tableName, String condition) throws SQLException;
	public void incertUser(String tableName, List<Columns> columnsNames, List<String> parameters) throws SQLException;
	public void incertTicket(String tableName, List<String> columnsNames, List<String> parameters) throws SQLException;

	
}
