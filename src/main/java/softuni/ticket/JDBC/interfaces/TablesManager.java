package softuni.ticket.JDBC.interfaces;

import java.sql.SQLException;
import java.util.List;

import softuni.ticket.JDBC.tablesAndColumns.ColumnDef;
import softuni.ticket.JDBC.tablesAndColumns.Tables;

public interface TablesManager {
	void dropTable(String tableName) throws SQLException;
	boolean tableExists(String tableName) throws SQLException;
	List<String> getAllTables() throws SQLException;
	void createTable(String tableName, List<ColumnDef<?>> columns) throws SQLException;
	void addRimaryKey(Tables table, ColumnDef<?> col) throws SQLException;
}
