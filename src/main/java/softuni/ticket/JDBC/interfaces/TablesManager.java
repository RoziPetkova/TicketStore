package softuni.ticket.JDBC.interfaces;

import java.sql.SQLException;
import java.util.List;

import softuni.ticket.JDBC.tablesAndColumns.ColumnDef;

public interface TablesManager {
	public void createTable(String tableName, List<ColumnDef> columns) throws SQLException;
	public void dropTable(String tableName) throws SQLException;
	public boolean tableExists(String tableName) throws SQLException;
	public List<String> getAllTables() throws SQLException;
}
