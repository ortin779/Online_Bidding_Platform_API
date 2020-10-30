package com.biddingplatform.biddingplatform.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.biddingplatform.biddingplatform.daohelper.SqlConstantsHelper;
import com.biddingplatform.biddingplatform.models.Bid;

@Repository
public class BidDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	Logger logger = LoggerFactory.getLogger(BidDAO.class);

	private static final class BidsRowMapper implements RowMapper<Bid> {

		@Override
		public Bid mapRow(ResultSet rs, int rowNum) throws SQLException {
			Bid bid = new Bid();
			bid.setBidId(rs.getInt(1));
			bid.setBidValue(rs.getFloat(2));
			bid.setCustomerId(rs.getInt(3));
			bid.setProductId(rs.getInt(4));
			bid.setBidStatus(rs.getInt(5));
			return bid;
		}
	}

	public int addBid(Bid bid) {
		Bid isExisting = checkBid(bid.getCustomerId(), bid.getProductId());
		if (isExisting == null) {
			return jdbcTemplate.update(SqlConstantsHelper.addBidQuery, new Object[] { bid.getBidId(), bid.getBidValue(),
					bid.getCustomerId(), bid.getProductId(), bid.getBidStatus() });
		} else {
			return jdbcTemplate.update(SqlConstantsHelper.updateBidQuery,
					new Object[] { bid.getBidValue(), bid.getCustomerId(), bid.getProductId() });
		}
	}

	public List<Bid> getReceivedBids(int id) {
		return jdbcTemplate.query(SqlConstantsHelper.getReceivedBidsQuery, new Object[] { id }, new BidsRowMapper());

	}

	public List<Bid> getPlacedBids(int id) {
		return jdbcTemplate.query(SqlConstantsHelper.getPlacedBidsQuery, new Object[] { id }, new BidsRowMapper());

	}

	public Bid checkBid(int custId, int prodId) {
		List<Bid> bids = jdbcTemplate.query(SqlConstantsHelper.checkBidQuery, new Object[] { custId, prodId },
				new BidsRowMapper());
		if(bids.isEmpty()) {
			return null;
		}
		return bids.get(0);
	}

	public int acceptBid(int bidId) {
		return jdbcTemplate.update(SqlConstantsHelper.acceptBidQuery, new Object[] { bidId });

	}

	public Bid getBidByBidId(int bidId) {

		List<Bid> bids =  jdbcTemplate.query(SqlConstantsHelper.getBidByBidIdQuery, new Object[] { bidId },
				new BidsRowMapper());
		if(bids.isEmpty()) {
			return null;
		}
		return bids.get(0);
	}
}
