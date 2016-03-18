package com.javaspring.tutorial.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;

@Component("offersDAO")
public class OffersDAO {

	// private JdbcTemplate jdbc;
	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		// this.jdbc = new JdbcTemplate(jdbc);
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public List<Offers> getOffers() {

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("user", "John");

		return jdbc.query("select * from offers", new RowMapper<Offers>() {

			public Offers mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offers offers = new Offers();
				offers.setId(rs.getInt("id"));
				offers.setName(rs.getString("name"));
				offers.setEmail(rs.getString("email"));
				offers.setText(rs.getString("text"));
				return offers;
			}
		});
	}

	public boolean update(Offers offers) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offers);
		return jdbc.update("update offers set name=:name, email = :email, text=:text where id = :id", params) == 1;
	}

	public boolean create(Offers offers) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offers);
		return jdbc.update("insert into offers(`name`,`email`,`text`) values (:name,:email,:text)", params) == 1;
	}
	
	public int[] create(List<Offers> offers) {
		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(offers.toArray());
		return jdbc.batchUpdate("insert into offers(`name`,`email`,`text`) values (:name,:email,:text)", params);
	}

	public boolean delete(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource("id", id);
		return jdbc.update("delete from offers where id = :id", params) == 1;
	}

	public Offers getUserOffers(int id) {

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);

		return jdbc.queryForObject("select * from offers where id = :id",
				params, new RowMapper<Offers>() {

					public Offers mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Offers offers = new Offers();
						offers.setId(rs.getInt("id"));
						offers.setName(rs.getString("name"));
						offers.setEmail(rs.getString("email"));
						offers.setText(rs.getString("text"));
						return offers;
					}
				});
	}
}
