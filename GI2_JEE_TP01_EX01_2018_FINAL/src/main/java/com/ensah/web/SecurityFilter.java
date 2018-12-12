package com.ensah.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ensah.bo.Player;

/**
 * This filter runs every time a user requests a resource that requires
 * authentfication
 * 
 * These request starts with /private
 * 
 * @author boudaa
 *
 */

@WebFilter(urlPatterns = "/private/*")
public class SecurityFilter implements Filter {

	/** defines the login form location */
	private static final String CONNEXION_PAGE = "/pages/public/loginForm.jsp";

	public SecurityFilter() {

	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("Securtit Filter started....");

		HttpServletRequest rq = (HttpServletRequest) request;

		// Get the session

		HttpSession session = rq.getSession();

		// get user form session
		Player user = (Player) session.getAttribute("user");

		// if user not logged
		if (user == null) {

			// redirect to the login page
			rq.getRequestDispatcher(CONNEXION_PAGE).forward(request, response);

		} else {
			// else chain to the next filter or the next resource in the chain
			chain.doFilter(request, response);

		}

		System.out.println("We can do some post processing here....");

	}

}
