package softuni.ticket.mapedServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import softuni.ticket.JDBC.JDBCManagerImpl;
import softuni.ticket.JDBC.tavlesAndColumns.Tables;

public class CreateEventTicket extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("eventName");
		String location = req.getParameter("eventLocation");
		String date = req.getParameter("eventDate");
		
		/*
		try {
			java.util.Date date = new SimpleDateFormat("dd MMM yyyy").parse(req.getParameter("eventDate"));
			
			java.sql.Date eventDate = new java.sql.Date(date.getDate());
			
		} catch (ParseException e) {
			e.printStackTrace();
			resp.getWriter().write("Invalid date format.");
		}
		*/
		
		int ticketsAmmount = Integer.parseInt(req.getParameter("ticketsAmmount"));
		String eventInfo = req.getParameter("eventInfo"); // Event description/presentation text.
		double ticketPrice = Double.parseDouble(req.getParameter("ticketPrice"));
		
		String sql = String.format("INSERT INTO %s"
				+ " VALUES (1, '%s', '%s','%s', '%d', '%S', '%d')", 
				Tables.Tickets.name(), name, location, date, ticketsAmmount, eventInfo, ticketPrice);
		
		
		try {
			JDBCManagerImpl.getInstance().executeDDL(sql);
			PrintWriter writer = resp.getWriter();
			
			writer.write(String.format("<html> Tickets for event %s successfully added. </html>", name));
		} catch (SQLException e) {
			e.printStackTrace();
			resp.getWriter().write("Something went wrong:");
		}
	}
	
	

}
