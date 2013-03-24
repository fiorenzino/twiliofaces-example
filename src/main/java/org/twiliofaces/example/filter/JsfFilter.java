package org.twiliofaces.example.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class JsfFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		Wrapper responseWrapper = new Wrapper((HttpServletResponse) response);
		chain.doFilter(request, responseWrapper);
		// I just want the output on stdout at the moment...
		System.out.println(responseWrapper.toString());
		PrintWriter out = response.getWriter();
		out.write(responseWrapper.toString());
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
