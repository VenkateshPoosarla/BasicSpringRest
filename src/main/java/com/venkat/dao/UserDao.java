package com.venkat.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.venkat.model.User;
@Repository
public class UserDao {
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private static final Logger log = Logger.getLogger(UserDao.class.getName());

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public User findById(String id) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);

		String sql = "SELECT * FROM users WHERE id=:id";

		User result = namedParameterJdbcTemplate.queryForObject(sql, params, new UserMapper());

		// new BeanPropertyRowMapper(Customer.class));

		return result;

	}

	public void createUser(User user) {
		// String SQL = "INSERT INTO Employee (name, age, salary) VALUES (:name,
		// :age, :salary)";
		String SQL = "INSERT INTO USERS ( ID, FIRSTNAME, MIDDLENAME, LASTNAME, AGE, GENDER, PHONE, ZIP ) VALUES ( :ID,:FIRSTNAME, :MIDDLENAME, :LASTNAME, :AGE, :GENDER, :PHONE, :ZIP)";
		Map<String, Object> namedParameters = new HashMap<String, Object>();
		namedParameters.put("ID", user.getId());
		namedParameters.put("FIRSTNAME", user.getFirstName());
		namedParameters.put("MIDDLENAME", user.getMiddleName());
		namedParameters.put("LASTNAME", user.getLastName());
		namedParameters.put("AGE", user.getAge());
		namedParameters.put("GENDER", user.getGender());
		namedParameters.put("PHONE", user.getPhone());
		namedParameters.put("ZIP", user.getZip());
		namedParameterJdbcTemplate.update(SQL, namedParameters);

	}

	public void updateUserPhone(String id, String phone) {
		String SQL = "UPDATE USERS SET PHONE = :PHONE WHERE ID = :ID";
		Map<String, Object> namedParameters = new HashMap<String, Object>();
		namedParameters.put("ID", id);
		namedParameters.put("PHONE", phone);
		namedParameterJdbcTemplate.update(SQL, namedParameters);
		System.out.println("Updated Record with ID = " + id);

	}

	public List<User> findAll() {

		Map<String, Object> params = new HashMap<String, Object>();

		String sql = "SELECT * FROM users";

		List<User> result = namedParameterJdbcTemplate.query(sql, params, new UserMapper());

		return result;

	}

	/*
	 * TODO
	 * 
	 */
	private static final class UserMapper implements RowMapper<User> {

		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getString("ID"));
			user.setFirstName(rs.getString("FIRSTNAME"));
			user.setMiddleName(rs.getString("MIDDLENAME"));
			user.setLastName(rs.getString("LASTNAME"));
			user.setAge(rs.getInt("AGE"));
			user.setGender(rs.getString("GENDER"));
			user.setPhone(rs.getString("PHONE"));
			user.setPhone(rs.getString("ZIP"));

			// user.setEmail(rs.getString("email"));
			return user;
		}
	}

}
