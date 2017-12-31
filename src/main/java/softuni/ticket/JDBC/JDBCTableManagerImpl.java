package softuni.ticket.JDBC;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import softuni.ticket.JDBC.interfaces.ColumnDef;
import softuni.ticket.JDBC.interfaces.JDBCManager;
import softuni.ticket.JDBC.interfaces.TablesManager;

public class JDBCTableManagerImpl implements TablesManager {
	
	private static TablesManager instance = null;
	private JDBCManager jdbcmanager;

	private JDBCTableManagerImpl() {
		jdbcmanager = JDBCManagerImpl.getInstance();
	}

	public static TablesManager getInstance() {
		if (instance == null) {
			instance = new JDBCTableManagerImpl();
		}
		return instance;
	}

	@Override
	public void createTable(String tableName, List<ColumnDef> columns) throws SQLException {
		jdbcmanager.executeQuery(String.format(
				"CREATE TABLE %s (%s)", tableName,
				columns
				.stream()
				.map(colDef -> colDef.getName() + " " + colDef.getType())
				.collect(Collectors.joining(", "))));
	}

	@Override
	public void dropTable(String tableName) throws SQLException {
		jdbcmanager.executeDDL(String.format("DROP TABLE %s", tableName));
	}
	
	@Override
	public boolean tableExists(String tableName) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
}
