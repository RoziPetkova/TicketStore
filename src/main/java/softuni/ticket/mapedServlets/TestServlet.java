package softuni.ticket.mapedServlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//"/testServlet"
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int x = Integer.parseInt(req.getParameter("a"));
		int y = Integer.parseInt(req.getParameter("b"));
		resp.getWriter().write("<html>" +  (x*y) + "</html>");
	}
}
