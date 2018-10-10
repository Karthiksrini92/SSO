package com.sso.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;


import com.sso.model.SSO;
public class SSODAOImpl implements SSODAO {
	private JdbcTemplate jdbcTemplate;

	public SSODAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void saveOrUpdate(SSO sso) {
		// TODO Auto-generated method stub
		if (sso.getSsoRequestId() > 0) {
			// update
			String sql = "UPDATE SSO SET Purpose=?, Prod_URL=?, Prod_Deploy_Date=?,Test_URL=?,Test_Deploy_Date=?,Two_Factor_Authentication=?,Technical_ID=?,Requester_ID=? "
					+ "WHERE SSO_Request_ID=?";
			jdbcTemplate.update(sql, sso.getPurpose(), sso.getProdURL(),sso.getProdDeployDate(),sso.getTestURL(),sso.getTestDeployDate(),sso.getTwoFactorAuthentication(),sso.getTechnicalId(),sso.getRequesterId());
		} else {
			// insert
			String sql = "INSERT INTO SSO (SSO_Request_ID, Purpose, Prod_URL, Prod_Deploy_Date,Test_URL,Test_Deploy_Date,Two_Factor_Authentication,Technical_ID,Requester_ID)"
					+ " VALUES (?, ?, ?, ?,?,?,?,?,?)";
			jdbcTemplate.update(sql, sso.getSsoRequestId(), sso.getPurpose(),sso.getProdURL(),sso.getProdDeployDate(),sso.getTestURL(),sso.getTestDeployDate(),sso.getTwoFactorAuthentication(),sso.getTechnicalId(),sso.getRequesterId());
		}

	}

	@Override
	public void delete(int SsoRequestId ) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM SSO WHERE SSO_Requester_ID=?";
		jdbcTemplate.update(sql, SsoRequestId);
	}

	@Override
	public SSO get(int SsoRequestId) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM SSO WHERE SSO_Requester_ID=" + SsoRequestId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<SSO>() {

			@Override
			public SSO extractData(ResultSet rs) throws SQLException,
			DataAccessException {
				if (rs.next()) {
					SSO sso = new SSO();
					sso.setSsoRequestId(rs.getInt("SSO_Requester_ID"));
					sso.setPurpose(rs.getString("Purpose"));
					sso.setProdURL(rs.getString("Prod_URL"));
					sso.setProdDeployDate(rs.getDate("Prod_Deploy_Date"));
					sso.setTestURL(rs.getString("Test_URL"));
					sso.setTestDeployDate(rs.getDate("Test_Deploy_Date"));
					sso.setTwoFactorAuthentication(rs.getString("Two_Factor_Authentication"));
					sso.setTechnicalId(rs.getInt("Technical_ID"));
					sso.setRequesterId(rs.getInt("Requester_ID"));
					
					return sso;
				}

				return null;
			}

		});
	}

	@Override
	public List<SSO> list() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM SSO";
		List<SSO> listSSO = jdbcTemplate.query(sql, new RowMapper<SSO>() {

			@Override
			public SSO mapRow(ResultSet rs, int rowNum) throws SQLException {
				SSO asso = new SSO();

				asso.setSsoRequestId(rs.getInt("SSO_Requester_ID"));
				asso.setPurpose(rs.getString("Purpose"));
				asso.setProdURL(rs.getString("Prod_URL"));
				asso.setProdDeployDate(rs.getDate("Prod_Deploy_Date"));
				asso.setTestURL(rs.getString("Test_URL"));
				asso.setTestDeployDate(rs.getDate("Test_Deploy_Date"));
				asso.setTwoFactorAuthentication(rs.getString("Two_Factor_Authentication"));
				asso.setTechnicalId(rs.getInt("Technical_ID"));
				asso.setRequesterId(rs.getInt("Requester_ID"));

				return asso;
			}

		});

		return listSSO;
	}


}
