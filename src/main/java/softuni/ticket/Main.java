package softuni.ticket;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

import softuni.ticket.JDBC.JDBCManagerImpl;
import softuni.ticket.JDBC.interfaces.JDBCManager;
import softuni.ticket.mapedServlets.AuthenticateFilter;
import softuni.ticket.mapedServlets.AuthenticateServlet;
import softuni.ticket.mapedServlets.CreateEventTicket;
import softuni.ticket.mapedServlets.Search;
import softuni.ticket.mapedServlets.LogOutServlet;
import softuni.ticket.mapedServlets.SignNewUser;

public class Main {
	//resources
	public static void main(String[] args) throws Throwable {
		JDBCManager mgr = null;
		Server server = null;
		try {
			mgr = initializeDB();
			server = getServer();
			server.join();
		} catch (Throwable ex) {
			throw ex;
		} finally {
			if(mgr != null)
				mgr.closeConnection();
			if(server != null)
				server.stop();
		}
	}

	public static JDBCManager initializeDB() {
		return JDBCManagerImpl.getInstance();
	}

	public static Server getServer() throws Throwable {
		Server server = new Server(8088);

		ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
		server.setHandler(handler);
		
		handler.addServlet(SignNewUser.class, "/singNewUser");
		handler.addServlet(AuthenticateServlet.class, "/authenticate");
		handler.addServlet(LogOutServlet.class, "/logout");
        handler.addServlet(CreateEventTicket.class, "/createEvent");
		handler.addServlet(Search.class,"/search");
		
		handler.addFilter(AuthenticateFilter.class, "/*", null);		
		handler.addEventListener(new ServerInitializedListener());

		server.start();

		return server;
	}
}
