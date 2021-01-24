package com.la.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */

public class AuthenticationFilter implements Filter  {

    /**
     * Default constructor. 
     */
    public AuthenticationFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();

		String url = req.getServletPath();
		boolean allowedRequest = false;
		
		if(url.contains("login")) {
			allowedRequest = true;
		}else {
		
			Integer userId = 0;
		
			if(session!=null && session.getAttribute("userId")!=null) {
				userId = (int)session.getAttribute("userId") ;
			}
		
			if(userId>0) {
				allowedRequest = true;
			}
			
		}
		
		if(!allowedRequest) {
			session.setAttribute("error", " Please login to Access the Portal!!");
		    res.sendRedirect("login.jsp");
		}else {			
			// pass the request along the filter chain
			try{
			chain.doFilter(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
