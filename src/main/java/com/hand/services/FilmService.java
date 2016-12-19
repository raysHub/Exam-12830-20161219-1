package com.hand.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.hand.common.ConnectionFactory;
import com.hand.dao.FilmDao;
import com.hand.dao.impl.FilmDaoImpl;
import com.hand.entity.Film;

public class FilmService {

	private FilmDao filmDao = new FilmDaoImpl();

	/**
	 * @return   装有所有film的list
	 */
	public List<Film> showAllFilms(int pageNow, int pageSize) {
		Connection conn = null;
		List<Film> list = null;
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			conn.setAutoCommit(false);
			// 去dao里面拿到结果集（如果没找到就是null）
			list = new LinkedList<Film>(filmDao.getAllFilms(conn, pageNow, pageSize));
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			// 捕获到异常就rollback它
			try {
				conn.rollback();
			} catch (Exception e2) {
			}
		} finally {
			// 用了就得关
			try {
				conn.close();
			} catch (Exception e2) {
			}
		}
		return list;
	}
	
	/**
	 * @param film 指定要删除的film
	 */
	public void delete(Film film){
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			conn.setAutoCommit(false);
			// 去dao里面执行删除(逻辑删除)
			filmDao.delete(conn, film);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			// 捕获到异常就rollback它
			try {
				conn.rollback();
			}   catch (Exception e2) {
				e.printStackTrace();
			}
		} finally {
			// 用了就得关
			try {
				conn.close();
			} catch (Exception e2) {
			}
		}
	}

}
