package com.callor.jdbc.persistance.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.callor.jdbc.model.AuthorVO;
import com.callor.jdbc.model.CompanyVO;
import com.callor.jdbc.persistance.AuthorDao;

public class AuthorDaoImplV1 implements AuthorDao{

	protected final JdbcTemplate jdbcTemplate;

	public AuthorDaoImplV1(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<AuthorVO> selectAll() {

		String sql = "select * from tbl_author";
		
		List<AuthorVO> auList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<AuthorVO>(AuthorVO.class));
		return null;
	}

	@Override
	public AuthorVO findById(String pk) {
		// TODO Auto-generated method stub
		String sql = "select * from tbl_author ";
		sql += " where au_code = ? ";
		Object[] params = new Object[] {pk};
		AuthorVO vo = (AuthorVO) jdbcTemplate.query(sql,params, new BeanPropertyRowMapper<AuthorVO>(AuthorVO.class));
		return null;
	}

	@Override
	public int insert(AuthorVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(AuthorVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String pk) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<AuthorVO> findByAName(String aname) {
		// TODO Auto-generated method stub
		
		String sql = "select * from tbl_author ";
		sql += "where au_title = ? ";
		Object[] params = new Object[] {aname};
		AuthorVO vo = (AuthorVO) jdbcTemplate.query(sql,params, new BeanPropertyRowMapper<AuthorVO>(AuthorVO.class));
		
		return null;
	}

	@Override
	public List<AuthorVO> findByATel(String tel) {
		// TODO Auto-generated method stub
		
		String sql = "select * from tbl_author ";
		sql += "where au_tel = ? ";
		Object[] params = new Object[] {tel};
		AuthorVO vo = (AuthorVO) jdbcTemplate.query(sql,params, new BeanPropertyRowMapper<AuthorVO>(AuthorVO.class));
		
		return null;
	}

}
