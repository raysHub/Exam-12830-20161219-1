package com.hand.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class FileterOne
 */
public class EncodingFilter implements Filter {
	
	private String encoding = null;

	/**
	 * Default constructor.
	 */
	public EncodingFilter() {
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// servlet的初始化方法在被调用的时候执行，过滤器的初始化方法在容器启用的时候就调用
		encoding = fConfig.getInitParameter("encoding");
		if(encoding == null){
			throw new ServletException("encoding中的编码设置为空");
		}
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 * 	同servlet的service方法
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if(!encoding.equals(request.getCharacterEncoding())){
			request.setCharacterEncoding(encoding);
		}
		response.setCharacterEncoding(encoding);
		//如果要用chain，这个东西就有用，否则没用。留着吧
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

}
