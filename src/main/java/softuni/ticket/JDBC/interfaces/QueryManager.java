package softuni.ticket.JDBC.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import softuni.ticket.JDBC.tablesAndColumns.Columns;

public interface QueryManager {
	public ResultSet selectFromTable(String tableNAme) throws SQLException;
	public ResultSet selectFromTable(String tableName, List<Columns> columns) throws SQLException;
	public ResultSet selectFromTableWhere(String tableName, String condition) throws SQLException;
	public void insertUser(String tableName, List<Columns> columnsNames, List<String> parameters) throws SQLException;
	public void insertTicket(String tableName, List<String> columnsNames, List<String> parameters) throws SQLException;
}
