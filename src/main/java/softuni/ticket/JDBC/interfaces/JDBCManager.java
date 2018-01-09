package softuni.ticket.JDBC.interfaces;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface JDBCManager {
	public ResultSet executeQuery(String sql) throws SQLException;
	public void executeDDL(String sql) throws SQLException;
	public PreparedStatement prepareStatement(String sql) throws SQLException;
	public void closeConnection() throws SQLException;
}