package com.sso.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;


import com.sso.model.Technical_Contact;
public class Technical_ContactDAOImpl implements Technical_ContactDAO {
	private JdbcTemplate jdbcTemplate;
	public Technical_ContactDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(Technical_Contact techcontact) {
		// TODO Auto-generated method stub
		if (techcontact.getTechnicalId() > 0) {
			// update
			String sql = "UPDATE Technical_Contact SET Name=?, Phone=?, Email=?, Department=?,"
					+ "WHERE Technical_ID=?";
			jdbcTemplate.update(sql, techcontact.getName(), techcontact.getPhone(), techcontact.getEmail(),techcontact.getDepartment());
		} else {
			// insert
			String sql = "INSERT INTO Technical_Contact (Technical_ID, Name, Phone, Email,Department)"
					+ " VALUES (?, ?, ?, ?,?,?,?,?,?)";
			jdbcTemplate.update(sql, techcontact.getTechnicalId(), techcontact.getName(),techcontact.getPhone(),techcontact.getEmail(),techcontact.getDepartment());
		}

	}

	@Override
	public void delete(int techId ) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM Technical_Contact WHERE Technical_ID=?";
		jdbcTemplate.update(sql, techId);
	}

	@Override
	public Technical_Contact get(int techId) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM Technical_Contact WHERE Technical_ID=" + techId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Technical_Contact>() {

			@Override
			public Technical_Contact extractData(ResultSet rs) throws SQLException,
			DataAccessException {
				if (rs.next()) {
					Technical_Contact techcon = new Technical_Contact();
					techcon.setTechnicalId(rs.getInt("Requester_ID"));
					techcon.setName(rs.getString("Name"));
					techcon.setEmail(rs.getString("Email"));
					techcon.setPhone(rs.getString("Phone"));
					techcon.setDepartment(rs.getString("Department"));
			
				
					
					return techcon;
				}

				return null;
			}

		});
	}

	@Override
	public List<Technical_Contact> list() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM Technical_Contact";
		List<Technical_Contact> listSSO = jdbcTemplate.query(sql, new RowMapper<Technical_Contact>() {

			@Override
			public Technical_Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
				Technical_Contact atechcon = new Technical_Contact();

				atechcon.setTechnicalId(rs.getInt("Requester_ID"));
				atechcon.setName(rs.getString("Name"));
				atechcon.setEmail(rs.getString("Email"));
				atechcon.setPhone(rs.getString("Phone"));
				atechcon.setDepartment(rs.getString("Department"));

				return atechcon;
			}

		});

		return listSSO;
	}

}
