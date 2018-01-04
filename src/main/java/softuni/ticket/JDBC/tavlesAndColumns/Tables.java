package softuni.ticket.JDBC.tavlesAndColumns;

import static softuni.ticket.JDBC.tavlesAndColumns.Columns.*;

import java.util.Arrays;
import java.util.List;

public enum Tables {
	Tickets(Arrays.asList(
		TICKET_ID.getColumnDefs(), 
		NAME.getColumnDefs(), 
		LOCATION.getColumnDefs(),
		EVENT_DATE.getColumnDefs(),
		AMOUNT.getColumnDefs(), 
		INFORMATION.getColumnDefs(), 
		TICKET_PRICE.getColumnDefs())),
	
	Users(Arrays.asList(
		USER_ID.getColumnDefs(), 
		NAME.getColumnDefs(), 
		PASSWORD.getColumnDefs())),
	
	SoldTickets(Arrays.asList(
			TICKET_ID.getColumnDefs(), 
			USER_ID.getColumnDefs()));

	private List<ColumnDef> columnDefs;

	private Tables(List<ColumnDef> columnDefs) {
		this.columnDefs = columnDefs;
	}

	public List<ColumnDef> getColumnDefs() {
		return columnDefs;
	}
}
