package softuni.ticket.mapedServlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthenticateServlet extends HttpServlet {
	public static final String USER = "user";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user = req.getParameter("username");
		String pass = req.getParameter("password");
		
		// select pass user ...
		if (user != null && pass != null && user.equals("admin") && pass.equals("admin")) {
			HttpSession session = req.getSession(true);
			session.setAttribute(USER, user);
			
			resp.getWriter().write("<html> user authenticated </html>");
		}

		else { 
			resp.getWriter().write("<html> user NOT correct </html>");
		}
	}
}