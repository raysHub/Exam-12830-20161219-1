package com.hand.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.hand.dao.CustomerDao;
import com.hand.entity.Customer;

public class CustomerDaoImpl implements CustomerDao {

	/**
	 * 保存用户信息 预留
	 * 
	 */
	@Override
	public void save(Connection conn, Customer customer) throws SQLException {

	}

	/**
	 * 根据用户指定的ID更新用户信息 预留
	 */
	@Override
	public void update(Connection conn, Long id, Customer customer) throws SQLException {
		String sql = "UPDATE customer SET  where ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.execute();
	}

	/**
	 * 删除指定用户信息 预留
	 */
	@Override
	public void delete(Connection conn, Long id, Customer customer) throws SQLException {
		String sql = "UPDATE customer SET active=0  where ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.execute();
	}

	/**
	 * 获取指定用户信息（如果不存在就返回null）
	 */
	@Override
	public List<Customer> getCustomer(Connection conn, Customer customer) throws SQLException {
		String sql = "SELECT * FROM customer WHERE first_name=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, customer.getFirst_name());
		// 如果存在，把该costumer的信息拿出来
		List<Customer> list = new LinkedList<Customer>();
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			// 如果传一个数字就是第几列，比如第一列是id，第二列是store_id
			customer.setId(Long.parseLong(rs.getString("customer_id")));
			list.add(customer);
		}
		return list;
	}

}
