package softuni.ticket.JDBC;

import java.util.Arrays;
import java.util.List;

import softuni.ticket.JDBC.interfaces.ColumnDef;

public enum Table {
	Tickets(Arrays.asList(new ColumnDef("id", ColumnDef.DataType.Integer)));

	private List<ColumnDef> columnDefs;

	private Table(List<ColumnDef> columnDefs) {
		this.columnDefs = columnDefs;
	}

	public List<ColumnDef> getColumnDefs() {
		return columnDefs;
	}
}
