package com.biddingplatform.biddingplatform.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.biddingplatform.biddingplatform.daohelper.SqlConstantsHelper;
import com.biddingplatform.biddingplatform.models.Product;

@Repository
public class ProductDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	private static final class ProductRowMapper implements RowMapper<Product>{

		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			Product product = new Product();
			product.setProductId(rs.getInt("pid"));
			product.setSellerId(rs.getInt("seller_id"));
			product.setCategory(rs.getString("category"));
			product.setDescription(rs.getNString("prod_desc"));
			product.setImage(rs.getString("image"));
			product.setInitialBid(rs.getFloat("initial_bid"));
			product.setProductName(rs.getString("prod_name"));
			return product;
		}
		
	}
	
	public int saveProduct(Product product) {
		return jdbcTemplate.update(SqlConstantsHelper.addProductQuery,
				new Object[] {
				product.getProductId(),
				product.getProductName(),
				product.getDescription(),
				product.getImage(),
				product.getInitialBid(),
				product.getCategory(),
				product.getSellerId()
				});
	}
	
	public List<Product> getAllAuctionProducts(int userId){
		return jdbcTemplate.query(SqlConstantsHelper.getAllAuctionProductsQuery, new Object[] {userId}, new ProductRowMapper());
	}
	
	public List<Product> getMyAuctionProducts(int userId){
		return jdbcTemplate.query(SqlConstantsHelper.getMyAuctionProductsQuery, new Object[] {userId}, new ProductRowMapper());
	}
	
	public Product getProductById(int id){
		List<Product> products = jdbcTemplate.query(SqlConstantsHelper.getProductByIdQuery, new Object[] {id}, new ProductRowMapper());
		if(products.isEmpty()) {
			return null;
		}
		return products.get(0);
	}
	
	public int deleteProductById(int id) {
		return jdbcTemplate.update(SqlConstantsHelper.deleteProductByIdQuery,new Object[] {id});
	}
}
