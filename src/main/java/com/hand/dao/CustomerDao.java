package com.hand.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.hand.entity.Customer;

public interface CustomerDao {

	// 增
	public void save(Connection conn, Customer customer) throws SQLException;

	// 删
	public void delete(Connection conn, Long id, Customer customer) throws SQLException;

	// 改
	public void update(Connection conn, Long id, Customer customer) throws SQLException;

	// 查（单个）
	public List<Customer> getCustomer(Connection conn, Customer customer) throws SQLException;
}
