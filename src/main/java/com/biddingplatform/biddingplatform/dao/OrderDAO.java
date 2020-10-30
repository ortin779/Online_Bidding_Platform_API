package com.biddingplatform.biddingplatform.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.biddingplatform.biddingplatform.daohelper.SqlConstantsHelper;
import com.biddingplatform.biddingplatform.models.Order;

@Repository
public class OrderDAO {


	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final class OrdersRowMapper implements RowMapper<Order>{

		@Override
		public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
			Order order = new Order();
			order.setOrderId(rs.getInt(1));
			order.setOrderDate(rs.getDate(2));
			order.setProductId(rs.getInt(3));
			order.setProductName(rs.getString(4));
			order.setProductImage(rs.getString(5));
			order.setCategory(rs.getString(6));;
			order.setPrice(rs.getFloat(7));
			order.setCustomerId(rs.getInt(8));
			order.setSellerId(rs.getInt(9));
			return order;
		}
		
	}
	
	public int addOrder(Order order) {
		return jdbcTemplate.update(SqlConstantsHelper.addOrderQuery,
				new Object[] {
						order.getOrderId(),
						order.getOrderDate(),
						order.getProductId(),
						order.getProductName(),
						order.getProductImage(),
						order.getCategory(),
						order.getPrice(),
						order.getCustomerId(),
						order.getSellerId()
				});
	}
	
	public List<Order> getPlacedOrders(int customerId){
		return jdbcTemplate.query(SqlConstantsHelper.getPlacedOrdersQuery, new Object[] {customerId}, new OrdersRowMapper());

	}
	
	public List<Order> getReceivedOrders(int sellerId){
		return jdbcTemplate.query(SqlConstantsHelper.getReceivedOrdersQuery, new Object[] {sellerId}, new OrdersRowMapper());
	}
	
	public List<Order> getSortedOrders(String sortType,int customerId){
		switch(sortType.toLowerCase()) {
		case "today":
			return jdbcTemplate.query(SqlConstantsHelper.getTodayOrdersQuery,new Object[] {customerId},new OrdersRowMapper());
		case "week":
			return jdbcTemplate.query(SqlConstantsHelper.getWeekOrdersQuery,new Object[] {customerId},new OrdersRowMapper());
		case "month":
			return jdbcTemplate.query(SqlConstantsHelper.getMonthOrdersQuery,new Object[] {customerId},new OrdersRowMapper());
		case "year":
			return jdbcTemplate.query(SqlConstantsHelper.getYearOrdersQuery,new Object[] {customerId},new OrdersRowMapper());
		default:
			return null;
		}
	}
}
