package softuni.ticket.JDBC.tavlesAndColumns;

import static softuni.ticket.JDBC.tavlesAndColumns.ColumnDef.col;
import static softuni.ticket.JDBC.tavlesAndColumns.ColumnDef.DataType.*;

public enum Columns {

	USER_ID(col("USER_ID", INTEGER)),
	TICKET_ID(col("TICKET_ID", INTEGER)),
	PASSWORD(col("PASSWORD", VARCHAR)),
	NAME(col("USER_NAME", VARCHAR)),
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
