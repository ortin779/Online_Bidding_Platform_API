package com.biddingplatform.biddingplatform.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.biddingplatform.biddingplatform.daohelper.SqlConstantsHelper;
import com.biddingplatform.biddingplatform.models.CardDetails;

@Repository
public class CardDetailsDAO {
	
	
	private static final class CardDetailsRowMapper implements RowMapper<CardDetails>{

		@Override
		public CardDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
			CardDetails card = new CardDetails();
			card.setCardId(rs.getInt(1));
			card.setCardHolder(rs.getString(2));
			card.setCardNumber(rs.getLong(3));
			card.setMonth(rs.getInt(4));
			card.setYear(rs.getInt(5));
			card.setCvv(rs.getInt(6));
			card.setCustomerId(rs.getInt(7));
			return card;
		}
		
	}
	

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int addCardDetails(CardDetails card) {
			return jdbcTemplate.update(SqlConstantsHelper.addCardDetailsQuery,
					new Object[] {
							card.getCardId(),
							card.getCardHolder(),
							card.getCardNumber(),
							card.getMonth(),
							card.getYear(),
							card.getCvv(),
							card.getCustomerId()
					});

	}
	
	public List<CardDetails> findCardDetailsByCustomerId(int customerId){
			return jdbcTemplate.query(SqlConstantsHelper.getCardDetailsQuery, new Object[] {customerId}, new CardDetailsRowMapper());
	}
}
