package com.hand.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.entity.Customer;
import com.hand.services.LoginService;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private LoginService service = new LoginService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("userName");
		String returnUri = req.getParameter("returnUri");
		
		RequestDispatcher rd = null;
		String forward = "/index.jsp";

		// 连接数据库匹配账号，如果能找到就跳到success界面，否则到error界面
		if (userName == null) {
			req.setAttribute("msg", "用户名或密码为空");
			rd = req.getRequestDispatcher(forward);
			rd.forward(req, resp);
		} else {
			Customer customer = new Customer();
			customer.setFirst_name(userName);
			List<Customer> list = service.validate(customer);
			if (list.size() != 0) {
				customer.setId(list.get(0).getId());
				// 把拿到的信息放入request中
				req.setAttribute("Id", customer.getId());
				// 把登录状态放入session
				req.getSession().setAttribute("flag", "login_success");
				req.getSession().setAttribute("user", customer);
				if(returnUri != null){
					forward = returnUri;
				}
			}else{
				req.getSession().setAttribute("flag", "login_failure");
				forward = "/login.jsp";
				req.setAttribute("msg", "用户名错误");
			}
			rd = req.getRequestDispatcher(forward);
			rd.forward(req, resp);
		}
	}
}
