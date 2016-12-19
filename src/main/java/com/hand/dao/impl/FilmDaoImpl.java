package com.hand.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.hand.dao.FilmDao;
import com.hand.entity.Film;

public class FilmDaoImpl implements FilmDao {

	/**
	 * 	预留
	 */
	@Override
	public void save(Connection conn, Film film) throws SQLException {

	}

	/**
	 *   删除指定film
	 */
	@Override
	public void delete(Connection conn, Film film) throws SQLException {
		String sql = "delete from film WHERE film_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, film.getId().intValue());
		ps.execute();
	}

	/**
	 * 	预留
	 */
	@Override
	public void update(Connection conn, Film film) throws SQLException {

	}

	/**
	 * 	找出所有的film信息
	 */
	@Override
	public List<Film> getAllFilms(Connection conn, int pageNow, int pageSize) throws SQLException {
		String sql = "SELECT film_id,title,description,name FROM film,language WHERE film.language_id = language.language_id AND film_id  limit ?,?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, (pageNow-1)*pageSize);
		ps.setInt(2, pageSize);
		List<Film> list = new LinkedList<Film>();
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Film film = new Film();
			film.setId(Long.parseLong(rs.getString("film_id")));
			film.setTitle(rs.getString("title"));
			film.setDescription(rs.getString("description"));
			film.setLanguage(rs.getString("name"));
			list.add(film);
		}
		return list;
	}

}
