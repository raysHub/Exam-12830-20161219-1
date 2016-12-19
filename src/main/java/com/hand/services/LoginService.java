package com.hand.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.hand.common.ConnectionFactory;
import com.hand.dao.CustomerDao;
import com.hand.dao.impl.CustomerDaoImpl;
import com.hand.entity.Customer;

public class LoginService {

	private CustomerDao customerDao = new CustomerDaoImpl();

	/**
	 * @param customer
	 *            页面上输入的账号
	 * @return 如果数据库里面有这个账号，返回它的信息（这里只取了ID）如果没有，返回null
	 */
	public List<Customer> validate(Customer customer) {
		Connection conn = null;
		List<Customer> list = null;
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			conn.setAutoCommit(false);
			// 去dao里面拿到结果集（如果没找到就是null）
			 list = new LinkedList<Customer>(customerDao.getCustomer(conn, customer));
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

}
