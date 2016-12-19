package com.hand.servlet;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.entity.Film;
import com.hand.services.FilmService;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * Servlet implementation class FilmServlet
 */
public class ShowFilmsServlet extends HttpServlet {

	private FilmService filmService = new FilmService();

	private static final long serialVersionUID = 1L;
	
	private Configuration cfg = null;
	
	@SuppressWarnings("deprecation")
	@Override
	public void init() throws ServletException {
		// 创建freemarker实例
		cfg = new Configuration();
		// 指定freemarker模板文件的位置
		cfg.setServletContextForTemplateLoading(getServletContext(), "templates");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 做分页处理(因为总共有100页，不可能在页面上显示100个按钮，所以要做判断，没写了)
		int pageNow;
		if (request.getParameter("pageNow") != null) {
			pageNow = Integer.parseInt(request.getParameter("pageNow"));
		} else{
			pageNow = 1;
		}
		int pageSize = 10;
		// 建立数据模型
		Map<String, Object> root = new HashMap<String, Object>();
		// 拿数据
		List<Film> list = filmService.showAllFilms(pageNow,pageSize);
		// 插值
		// 因为从request里面取值取不到，所以把它存到ftl里面去
		root.put("pageNow", pageNow);
		root.put("records", list.size());
		root.put("allFilms", list);
		// 获取模板文件
		Template t = cfg.getTemplate("filmList.ftl");
		// 统一charset，这里使用text/html MIME-type 目前发现这句话少不了，过滤器代替不了它
		response.setContentType("text/html; charset=" + t.getEncoding());
		// 获得输出字符流
		Writer out = response.getWriter();
		try {
			// 合并数据模型和模板，并将结果输出到out中
			t.process(root, out);
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}

}
