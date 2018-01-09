package softuni.ticket.JDBC.tablesAndColumns;

import static softuni.ticket.JDBC.tablesAndColumns.ColumnDef.col;
import static softuni.ticket.JDBC.tablesAndColumns.ColumnDef.ColumnProperties.NOT_NULL;
import static softuni.ticket.JDBC.tablesAndColumns.ColumnDef.ColumnProperties.UNIQUE;
import static softuni.ticket.JDBC.tablesAndColumns.ColumnDef.ColumnProperties.AUTO_INCREMENT;
import static softuni.ticket.JDBC.tablesAndColumns.ColumnDef.DataType.*;

import java.math.BigDecimal;
import java.util.Date;

public interface Columns {
	ColumnDef<Integer> 
		USER_ID = col("USER_ID", INTEGER, NOT_NULL, AUTO_INCREMENT, UNIQUE),
		TICKET_ID = col("TICKET_ID", INTEGER, NOT_NULL, AUTO_INCREMENT, UNIQUE),
		AMOUNT = col("AMOUNT", INTEGER);

	ColumnDef<String>
		USER_NAME = col("USER_NAME", VARCHAR, NOT_NULL),
		TICKET_NAME = col("TICKET_NAME", VARCHAR, NOT_NULL),
		PASSWORD = col("PASSWORD", VARCHAR, NOT_NULL),
		INFORMATION = col("INFORMATION", VARCHAR),
		LOCATION = col("LOCATION", VARCHAR);

	ColumnDef<Date>
		EVENT_DATE = col("DATE", DATE);

	ColumnDef<BigDecimal>
		TICKET_PRICE = col("TICKET_PRICE", DECIMAL);
}
