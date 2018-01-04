package softuni.ticket;

import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import softuni.ticket.JDBC.TablesManagerImpl;
import softuni.ticket.JDBC.interfaces.TablesManager;
import softuni.ticket.JDBC.tavlesAndColumns.Tables;

public class ServerInitializedListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		TablesManager tablesManager = new TablesManagerImpl();
		for(Tables table : Tables.values()) {
			try {
				tablesManager.createTable(table.name(), table.getColumnDefs());
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// maybe nothing to do
	}
}