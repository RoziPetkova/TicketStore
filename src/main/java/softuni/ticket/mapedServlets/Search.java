package softuni.ticket.mapedServlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import softuni.ticket.Utils;
import softuni.ticket.JDBC.QueryManagerImpl;
import softuni.ticket.JDBC.interfaces.QueryManager;
import softuni.ticket.JDBC.tablesAndColumns.Columns;
import softuni.ticket.JDBC.tablesAndColumns.Tables;

public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private QueryManager queryManager;

	public Search() {
		queryManager = new QueryManagerImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Date date = Utils.toDate(req.getParameter("date"));
		String location = req.getParameter("location");
		String price = req.getParameter("price");

		String whereClause =
			date != null ? Columns.EVENT_DATE.getEqualsSQL(date):
			location != null ? Columns.LOCATION.getEqualsSQL(location):
			price != null ? Columns.TICKET_PRICE.getEqualsSQL(new BigDecimal(price)):
			"";
	
		try(ResultSet rs = queryManager.selectFromTableWhere(Tables.Tickets, whereClause)) {
			resp.setContentType("application/json");
			resp.getWriter().write(Utils.jsonSerialize(rs));
		} catch (SQLException e) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			resp.getWriter().write(Utils.jsonStacktrace(e));
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
}
