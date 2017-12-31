package softuni.ticket.JDBC.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface TablesManager {
	public void createTable(String tableName, List<ColumnDef> columns) throws SQLException;
	public void dropTable(String tableName) throws SQLException;
	public boolean tableExists(String tableName) throws SQLException;
}