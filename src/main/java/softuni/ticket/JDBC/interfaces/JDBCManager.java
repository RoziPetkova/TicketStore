package softuni.ticket.JDBC.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface JDBCManager {
	public ResultSet executeQuery(String sql) throws SQLException;
	public void executeDDL(String sql) throws SQLException;
}