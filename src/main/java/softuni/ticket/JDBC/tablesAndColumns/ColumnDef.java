package softuni.ticket.JDBC.tablesAndColumns;

public class ColumnDef {
	private String name;
	private DataType type;

	public ColumnDef(String name, DataType type) {
		this.name = name;
		this.type = type;		
	}
	
	public static ColumnDef col(String name, DataType type) {
		return new ColumnDef(name, type);
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type.toString();
	}

	public enum DataType {
		INTEGER("integer"),
		VARCHAR("varchar"),
		DATE("date"),
		DECIMAL("decimal");
		
		private String sqlType;

		private DataType(String sqlType) {
			this.sqlType = sqlType;
		}

		public String getSqlType() {
			return sqlType;
		}
	}
}
