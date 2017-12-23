package softuni.ticket.JDBC.interfaces;

public class ColumnDef {
	private String name;
	private DataType type;

	public ColumnDef(String name, DataType type) {
		this.name = name;
		this.type = type;		
	}

	public String getName() {
		return name;
	}

	public DataType getType() {
		return type;
	}

	private enum DataType {
		Integer("integer"),
		Varchar("varchar");

		private String sqlType;

		private DataType(String sqlType) {
			this.sqlType = sqlType;
		}

		@SuppressWarnings("unused")
		public String getSqlType() {
			return sqlType;
		}
	}
}
