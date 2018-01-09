package softuni.ticket.JDBC.interfaces;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import softuni.ticket.JDBC.tablesAndColumns.ColumnDef;
import softuni.ticket.JDBC.tablesAndColumns.Tables;

public interface QueryManager {
	public ResultSet selectFromTable(Tables table) throws SQLException;
	public ResultSet selectFromTable(Tables table, List<ColumnDef<?>> columns) throws SQLException;
	public ResultSet selectFromTableWhere(Tables table, List<ColumnDef<?>> columns, String condition) throws SQLException;
	public ResultSet selectFromTableWhere(Tables table, String condition) throws SQLException;
	public void insertUser(String username, String password) throws SQLException;
	public void insertTicket(String ticketName, String loation, java.util.Date date, int amound, String information, BigDecimal price) throws SQLException;
}
