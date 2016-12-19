package com.hand.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.hand.entity.Film;

public interface FilmDao {

	// 增
	public void save(Connection conn, Film film) throws SQLException;

	// 删
	public void delete(Connection conn, Film film) throws SQLException;

	// 改
	public void update(Connection conn, Film film) throws SQLException;

	// 查
	public List<Film> getAllFilms(Connection conn, int pageNow, int pageSize) throws SQLException;

}
