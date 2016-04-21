package atulrai;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterConfigFilter implements Filter {

	FilterConfig fConfig;

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		PrintWriter out = response.getWriter();

		String s = fConfig.getInitParameter("Construction");

		if (s.equals("yes")) {
			out.print("This page is under construction");
		} else {

			// pass the request along the filter chain
			chain.doFilter(request, response);

		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.fConfig = fConfig;
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

}
