package softuni.ticket.JDBC.tablesAndColumns;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ColumnDef {
	private String name;
	private DataType type;
	private String properties;

	private ColumnDef(String name, DataType type, ColumnProperties... prop) {
		this.name = name;
		this.type = type;
		this.setProp(prop);
	}
	
	public static ColumnDef col(String name, DataType type, ColumnProperties... prop) {
		return new ColumnDef(name, type, prop);
	}

	private void setProp(ColumnProperties...prop){
		if (prop.length > 0)
			this.properties = Arrays.asList(prop).stream()
					.map(ColumnProperties::getPropStr)
					.collect(Collectors.joining(" "));
		else
			this.properties = " ";
	}
	
	public String getName() {
		return name;
	}

	public String getType() {
		return type.toString();
	}
	public String getProperties() {
		return this.properties;
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
	
	public enum ColumnProperties {
		PRIMARY_KEY("PRIMARY KEY"),
		NOT_NULL("NOT NULL"),
		AUTO_INCREMENT("AUTO_INCREMENT"),
		UNIQUE("UNIQUE");
		
		private String info;

		private ColumnProperties(String information) {
			this.info = information;
		}

		public String getPropStr() {
			return this.info;
		}
	}
}
