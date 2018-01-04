package softuni.ticket.mapedServlets;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenticateFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if(request instanceof HttpServletRequest) {
			HttpServletRequest httpRequest = (HttpServletRequest) request;

			if(httpRequest.getRequestURI().startsWith("/authenticate") ||
				httpRequest.getRequestURI().startsWith("/singNewUser") ||
				(httpRequest.getSession(false) != null))
				chain.doFilter(request, response);
			else
				((HttpServletResponse) response).getWriter().write("You are not authenticated!!");
		}
	}

	@Override
	public void destroy() {
	}

}
