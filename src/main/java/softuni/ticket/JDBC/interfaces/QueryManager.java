package softuni.ticket.JDBC.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import softuni.ticket.JDBC.tablesAndColumns.Columns;
import softuni.ticket.JDBC.tablesAndColumns.Tables;

public interface QueryManager {
	public ResultSet selectFromTable(Tables table) throws SQLException;
	public ResultSet selectFromTable(Tables table, List<Columns> columns) throws SQLException;
	public ResultSet selectFromTableWhere(Tables table, List<Columns> column, String condition) throws SQLException;
	public void insertUser(Tables table, List<Columns> columnsNames, List<String> parameters) throws SQLException;
	public void insertTicket(Tables table, List<String> columnsNames, List<String> parameters) throws SQLException;
	
}
