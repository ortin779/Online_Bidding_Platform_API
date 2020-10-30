package com.biddingplatform.biddingplatform.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.biddingplatform.biddingplatform.daohelper.SqlConstantsHelper;
import com.biddingplatform.biddingplatform.models.User;

@Repository
public class UserDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;


	private static final class UserRowMapper implements RowMapper<User> {

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setFullName(rs.getString("fullname"));
			user.setUserName(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setEmail(rs.getString("email"));
			return user;
		}

	}

	public int registerUser(User user) {
		return jdbcTemplate.update(SqlConstantsHelper.registerUserQuery,
				new Object[] {
						user.getId(),
						user.getUserName(),
						user.getPassword(),
						user.getFullName(),
						user.getEmail()
				});
	}

	public User findUserByUsername(String username) {
		List<User> users = jdbcTemplate.query(SqlConstantsHelper.findUserByUserNameQuery, new Object[] { username },
				new UserRowMapper());
		if(users.isEmpty()) {
			return null;
		}
		return users.get(0);
	}

	public User findUserByEmail(String email) {

		List<User> users =  jdbcTemplate.query(SqlConstantsHelper.findUserByEmailQuery, new Object[] { email },
				new UserRowMapper());
		if(users.isEmpty()) {
			return null;
		}
		return users.get(0);
	}

	public int findUserIdByUserName(String name) {
		return jdbcTemplate.queryForObject(SqlConstantsHelper.findUserIdByUserNameQuery, new Object[] { name },
				Integer.class);
	}

	public String getUserName(int id) {

		return jdbcTemplate.queryForObject(SqlConstantsHelper.getFullNameByIdQuery, new Object[] { id }, String.class);

	}

	public String getEmailById(int id) {

		return jdbcTemplate.queryForObject(SqlConstantsHelper.getEmailIdQuery, new Object[] { id }, String.class);

	}

	public User getUserDetails(int id) {

		List<User> users =jdbcTemplate.query(SqlConstantsHelper.getUserDetailsQuery, new Object[] { id },
				new UserRowMapper());
		if(users.isEmpty()) {
			return null;
		}
		return users.get(0);
	}
}
