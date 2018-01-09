package softuni.ticket.JDBC.tablesAndColumns;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class ColumnDef<T> {
	private String name;
	private DataType type;
	private String properties;

	private ColumnDef(String name, DataType type, ColumnProperties... prop) {
		this.name = name;
		this.type = type;
		this.setProp(prop);
	}
	
	public static <T> ColumnDef<T> col(String name, DataType type, ColumnProperties... prop) {
		return new ColumnDef<T>(name, type, prop);
	}

	private void setProp(ColumnProperties...prop){
		if (prop.length > 0)
			this.properties = Arrays.asList(prop).stream()
					.map(ColumnProperties::getPropStr)
					.collect(Collectors.joining(" "));
		else
			this.properties = " ";
	}

	public String getSQL(T val, BiFunction<ColumnDef<T>, T, String> func) {
		return func.apply(this, val);
	}
	
	public String getEqualsSQL(T val) {
		if(getType() == DataType.VARCHAR)
			return getSQL(val, (col, value) -> String.format("%s = 	'%s'", col.getName(), value));
		else 
			return null;
	}

	public String getName() {
		return name;
	}

	public DataType getType() {
		return type;
	}

	public String getProperties() {
		return this.properties;
	}

	public enum DataType {
		INTEGER("integer", Integer.class),
		VARCHAR("varchar", String.class),
		DATE("date", Date.class),
		DECIMAL("decimal", BigDecimal.class);
		
		private String sqlType;
		private Class<?> javaType;

		private DataType(String sqlType, Class<?> javaType) {
			this.sqlType = sqlType;
			this.javaType = javaType;
		}

		public String getSqlType() {
			return sqlType;
		}

		public Class<?> getJavaType() {
			return javaType;
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
