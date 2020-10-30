package com.biddingplatform.biddingplatform.daohelper;

public class SqlConstantsHelper {
	//usersDAO Queries
	public static final String registerUserQuery = "insert into al387_users_tbl values(?,?,?,?,?)";
	public static final String findUserByUserNameQuery = "select * from al387_users_tbl where username=?";
	public static final String findUserByEmailQuery = "select * from al387_users_tbl where email=?";
	public static final String findUserIdByUserNameQuery = "select id from al387_users_tbl where username=?";
	public static final String getFullNameByIdQuery = "select fullname from al387_users_tbl where id=?";
	public static final String getEmailIdQuery = "select email from al387_users_tbl where id=?";
	public static final String getUserDetailsQuery = "select * from al387_users_tbl where id=?";
	
	//productsDAO Queries
	public static final String addProductQuery = "insert into al387_products_tbl values(?,?,?,?,?,?,?)";
	public static final String getAllAuctionProductsQuery = "select * from al387_products_tbl where seller_id != ? and pid not in (select product_id from al387_bids_tbl where bid_status=1)";
	public static final String getMyAuctionProductsQuery = "select * from al387_products_tbl where seller_id = ? and pid not in (select product_id from al387_bids_tbl where bid_status=1)";
	public static final String getProductByIdQuery = "select * from al387_products_tbl where pid=?";
	public static final String deleteProductByIdQuery = "delete from al387_products_tbl where pid=?";
	
	//BidsDAO Queries
	public static final String addBidQuery = "insert into al387_bids_tbl values(?,?,?,?,?)";
	public static final String updateBidQuery = "update al387_bids_tbl set bid_val=? where customer_id=? and product_id=?";
	public static final String getReceivedBidsQuery = "select * from al387_bids_tbl where product_id=?";
	public static final String getPlacedBidsQuery = "select * from al387_bids_tbl where customer_id=?";
	public static final String checkBidQuery = "select * from al387_bids_tbl where customer_id =? and product_id=?";
	public static final String acceptBidQuery = "update al387_bids_tbl set bid_status=1 where bid_id=?";;
	public static final String getBidByBidIdQuery = "select * from al387_bids_tbl where bid_id=?";
	
	//OrderDao
	public static final String addOrderQuery = "insert into al387_orders_tbl values(?,?,?,?,?,?,?,?,?)";
	public static final String getPlacedOrdersQuery = "select * from al387_orders_tbl where customer_id=?";
	public static final String getReceivedOrdersQuery = "select * from al387_orders_tbl where seller_id=?";
	public static final String getTodayOrdersQuery = "select * from al387_orders_tbl where order_date=curdate() and customer_id=?";
	public static final String getWeekOrdersQuery = "select * from al387_orders_tbl where week(order_date)=week(curdate()) and customer_id=?";
	public static final String getMonthOrdersQuery = "select * from al387_orders_tbl where month(order_date) = month(curdate()) and customer_id=?";
	public static final String getYearOrdersQuery = "select * from al387_orders_tbl where year(order_date) = year(curdate()) and customer_id=?";
	
	//CardDetailsDao
	public static final String addCardDetailsQuery = "insert into al387_card_details_tbl values(?,?,?,?,?,?,?)";
	public static final String getCardDetailsQuery = "select * from al387_card_details_tbl where customer_id=?";
}
