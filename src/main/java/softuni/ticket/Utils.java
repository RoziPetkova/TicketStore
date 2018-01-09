package softuni.ticket;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

public class Utils {
	public static Date toDate(String date) {
		try {
			return new SimpleDateFormat("dd-MMM-yyyy").parse(date);
		} catch (ParseException e1) {
			e1.printStackTrace();
			return null;
		}
	}

	public static String jsonSerialize(ResultSet rs) throws SQLException{
		JSONArray json = new JSONArray();
		ResultSetMetaData rsmd = rs.getMetaData();
		while (rs.next()) {
			int numColumns = rsmd.getColumnCount();
			JSONObject obj = new JSONObject();
			for (int i = 1; i <= numColumns; i++) {
				String column_name = rsmd.getColumnName(i);
				obj.put(column_name, rs.getObject(column_name));
			}

			json.put(obj);
		}

		return json.toString();
	}
	
	public static String jsonSerialize(String message){
		JSONArray json = new JSONArray();
			json.put(message);
		return json.toString();
	}
	
	public static String jsonStacktrace(SQLException ex) {
		return String.format("{exception:\"%s\"}", Arrays.toString(ex.getStackTrace()));
	}
	
	public static String jsonErrorMessage(SQLException ex) {
		return String.format("{exception:\"%s\"}", ex.getMessage());
	}

	public static String jsonErrorMessage(Exception e) {
		return String.format("{exception:\"%s\"}", Arrays.toString(e.getStackTrace()));
		
	}
}
