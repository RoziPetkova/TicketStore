package softuni.ticket.JDBC.tablesAndColumns;

import static softuni.ticket.JDBC.tablesAndColumns.Columns.AMOUNT;
import static softuni.ticket.JDBC.tablesAndColumns.Columns.EVENT_DATE;
import static softuni.ticket.JDBC.tablesAndColumns.Columns.INFORMATION;
import static softuni.ticket.JDBC.tablesAndColumns.Columns.LOCATION;
import static softuni.ticket.JDBC.tablesAndColumns.Columns.PASSWORD;
import static softuni.ticket.JDBC.tablesAndColumns.Columns.TICKET_ID;
import static softuni.ticket.JDBC.tablesAndColumns.Columns.TICKET_NAME;
import static softuni.ticket.JDBC.tablesAndColumns.Columns.TICKET_PRICE;
import static softuni.ticket.JDBC.tablesAndColumns.Columns.USER_ID;
import static softuni.ticket.JDBC.tablesAndColumns.Columns.USER_NAME;

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

	private List<ColumnDef<?>> columns;

	private Tables(List<ColumnDef<?>> columns) {
		this.columns = columns;
	}

	public List<ColumnDef<?>> getColumns() {
		return columns;
	}
}
