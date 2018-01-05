package softuni.ticket.JDBC.tablesAndColumns;

import static softuni.ticket.JDBC.tablesAndColumns.Columns.*;
import java.util.Arrays;
import java.util.List;

public enum Tables {
	Tickets(Arrays.asList(
		TICKET_ID, 
		TICKET_NAME, 
		LOCATION,
		EVENT_DATE,
		AMOUNT, 
		INFORMATION, 
		TICKET_PRICE)),
	
	Users(Arrays.asList(
		USER_ID, 
		USER_NAME, 
		PASSWORD)),
	
	SoldTickets(Arrays.asList(
		TICKET_ID, 
		USER_ID,
		AMOUNT));

	private List<Columns> columns;

	private Tables(List<Columns> columns) {
		this.columns = columns;
	}

	public List<Columns> getColumns() {
		return columns;
	}
}
