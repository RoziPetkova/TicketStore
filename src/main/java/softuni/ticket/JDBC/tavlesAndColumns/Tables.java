package softuni.ticket.JDBC.tavlesAndColumns;

import static softuni.ticket.JDBC.tavlesAndColumns.Columns.AMOUNT;
import static softuni.ticket.JDBC.tavlesAndColumns.Columns.EVENT_DATE;
import static softuni.ticket.JDBC.tavlesAndColumns.Columns.INFORMATION;
import static softuni.ticket.JDBC.tavlesAndColumns.Columns.LOCATION;
import static softuni.ticket.JDBC.tavlesAndColumns.Columns.NAME;
import static softuni.ticket.JDBC.tavlesAndColumns.Columns.PASSWORD;
import static softuni.ticket.JDBC.tavlesAndColumns.Columns.TICKET_ID;
import static softuni.ticket.JDBC.tavlesAndColumns.Columns.TICKET_PRICE;
import static softuni.ticket.JDBC.tavlesAndColumns.Columns.USER_ID;

import java.util.Arrays;
import java.util.List;

public enum Tables {
	Tickets(Arrays.asList(
		TICKET_ID, 
		NAME, 
		LOCATION,
		EVENT_DATE,
		AMOUNT, 
		INFORMATION, 
		TICKET_PRICE)),
	
	Users(Arrays.asList(
		USER_ID, 
		NAME, 
		PASSWORD)),
	
	SoldTickets(Arrays.asList(
		TICKET_ID, 
		USER_ID));

	private List<Columns> columns;

	private Tables(List<Columns> columns) {
		this.columns = columns;
	}

	public List<Columns> getColumns() {
		return columns;
	}
}
