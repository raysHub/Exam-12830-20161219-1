package com.hand.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.entity.Film;
import com.hand.services.FilmService;

/**
 * Servlet implementation class DeleteFilmServlet
 */
public class DeleteFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	FilmService filmService = new FilmService();

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
		String filmId = request.getParameter("filmId");
		Film film = new Film();
		System.out.println(filmId);
		film.setId(Long.parseLong(filmId));
		try {
			filmService.delete(film);
			request.setAttribute("deleteFlag", null);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("deleteFlag", "failure");
		}
		request.getRequestDispatcher("showFilmsServlet").forward(request, response);
	}

}
