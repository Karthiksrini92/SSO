package com.sso.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;


import com.sso.model.Requester_Contact;


public class Requester_ContactImpl implements Requester_ContactDAO {
	private JdbcTemplate jdbcTemplate;
	public Requester_ContactImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(Requester_Contact reqcontact) {
		// TODO Auto-generated method stub
		if (reqcontact.getRequesterId() > 0) {
			// update
			String sql = "UPDATE Requester_Contact SET Name=?, Phone=?, Email=?, Department=?,"
					+ "WHERE Requester_ID=?";
			jdbcTemplate.update(sql, reqcontact.getName(), reqcontact.getPhone(), reqcontact.getEmail(),reqcontact.getDepartment());
		} else {
			// insert
			String sql = "INSERT INTO Requester_Contact (Requester_ID, Name, Phone, Email,Department)"
					+ " VALUES (?, ?, ?, ?,?,?,?,?,?)";
			jdbcTemplate.update(sql, reqcontact.getRequesterId(), reqcontact.getName(),reqcontact.getPhone(),reqcontact.getEmail(),reqcontact.getDepartment());
		}

	}

	@Override
	public void delete(int requestId ) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM Requester_Contact WHERE Requester_ID=?";
		jdbcTemplate.update(sql, requestId);
	}

	@Override
	public Requester_Contact get(int requestId) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM Requester_Contact WHERE Requester_ID=" + requestId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Requester_Contact>() {

			@Override
			public Requester_Contact extractData(ResultSet rs) throws SQLException,
			DataAccessException {
				if (rs.next()) {
					Requester_Contact reqcon = new Requester_Contact();
					reqcon.setRequesterId(rs.getInt("Requester_ID"));
					reqcon.setName(rs.getString("Name"));
					reqcon.setEmail(rs.getString("Email"));
					reqcon.setPhone(rs.getString("Phone"));
					reqcon.setDepartment(rs.getString("Department"));
			
				
					
					return reqcon;
				}

				return null;
			}

		});
	}

	@Override
	public List<Requester_Contact> list() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM Requester_Contact";
		List<Requester_Contact> listSSO = jdbcTemplate.query(sql, new RowMapper<Requester_Contact>() {

			@Override
			public Requester_Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
				Requester_Contact areqcon = new Requester_Contact();

				areqcon.setRequesterId(rs.getInt("Requester_ID"));
				areqcon.setName(rs.getString("Name"));
				areqcon.setEmail(rs.getString("Email"));
				areqcon.setPhone(rs.getString("Phone"));
				areqcon.setDepartment(rs.getString("Department"));

				return areqcon;
			}

		});

		return listSSO;
	}

}
