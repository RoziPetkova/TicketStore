package softuni.ticket.JDBC.tablesAndColumns;

import static softuni.ticket.JDBC.tablesAndColumns.ColumnDef.col;
import static softuni.ticket.JDBC.tablesAndColumns.ColumnDef.DataType.*;
import static softuni.ticket.JDBC.tablesAndColumns.ColumnDef.ColumnProperties.*;

public enum Columns {

	USER_ID(col("USER_ID", INTEGER, NOT_NULL, UNIQUE)),
	TICKET_ID(col("TICKET_ID", INTEGER, NOT_NULL, UNIQUE)),
	USER_NAME(col("USER_NAME", VARCHAR, NOT_NULL)),
	TICKET_NAME(col("TICKET_NAME", VARCHAR, NOT_NULL)),
	PASSWORD(col("PASSWORD", VARCHAR, NOT_NULL)),
	EVENT_DATE(col("DATE", DATE)),
	TICKET_PRICE(col("TICKET_PRICE", DECIMAL)),
	INFORMATION(col("INFORMATION", VARCHAR)),
	LOCATION(col("LOCATION", VARCHAR)),
	AMOUNT(col("AMOUNT", INTEGER));
	
	private ColumnDef columnDefinition;

	private Columns(ColumnDef definition) {
		columnDefinition = definition;
	}

	public ColumnDef getColumnDefs() {
		return columnDefinition;
	}
}
