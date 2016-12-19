package com.hand.filter;

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
 * Servlet Filter implementation class PermissionFilter
 */
public class PermissionFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public PermissionFilter() {
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		// 拿到servlet请求路径
		String servletPath = req.getServletPath();
		HttpSession session = req.getSession();
		String flag = (String) session.getAttribute("flag");
		// 如果用户访问的是首页，访问login.jsp或者执行登录操作，就将请求传下去
		if (servletPath != null && (("/login.jsp").equals(servletPath) || ("/index.jsp").equals(servletPath)
				|| ("/loginServlet").equals(servletPath))) {
			chain.doFilter(request, response);
		} else {
			if (flag != null && ("login_success").equals(flag)) {
				chain.doFilter(request, response);
			} else if (flag != null && ("login_failure").equals(flag)) {
				req.setAttribute("msg", "登录失败，请重新登录");
				req.setAttribute("returnUri", servletPath);
				req.getRequestDispatcher("/login.jsp").forward(req, response);
			} else {
				req.setAttribute("msg", "请先登录");
				req.setAttribute("returnUri", servletPath);
				req.getRequestDispatcher("/login.jsp").forward(req, resp);
			}
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
	}
}
