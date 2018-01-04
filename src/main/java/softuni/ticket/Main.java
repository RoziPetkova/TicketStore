package softuni.ticket;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

import softuni.ticket.mapedServlets.AuthenticateFilter;
import softuni.ticket.mapedServlets.AuthenticateServlet;
import softuni.ticket.mapedServlets.CreateEventTicket;
import softuni.ticket.mapedServlets.LogOutServlet;
import softuni.ticket.mapedServlets.SignNewUser;
import softuni.ticket.mapedServlets.TestDataBase;
import softuni.ticket.mapedServlets.TestRozi2;
import softuni.ticket.mapedServlets.TestServlet;

public class Main {
	//resources
	public static void main(String[] args) throws Throwable {
		initialize();
	}

	public static void initialize() throws Throwable {
		Server server = new Server(8088);

		ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
		server.setHandler(handler);
		
		handler.addServlet(TestServlet.class, "/testServlet");
		handler.addServlet(TestRozi2.class, "/rozi");
		handler.addServlet(TestDataBase.class, "/dataBase");
		handler.addServlet(SignNewUser.class, "/singNewUser");
		handler.addServlet(AuthenticateServlet.class, "/authenticate");
		handler.addServlet(LogOutServlet.class, "/logout");
        handler.addServlet(CreateEventTicket.class, "/createEvent");
		
		handler.addFilter(AuthenticateFilter.class, "/*", null);

		handler.addEventListener(new ServerInitializedListener());

		try {
			server.start();
			server.join();
		}
		
		finally {
			System.exit(0);
		}
	}
}
