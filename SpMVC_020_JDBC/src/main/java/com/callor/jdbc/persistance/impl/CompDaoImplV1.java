package com.callor.jdbc.persistance.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.callor.jdbc.model.CompanyVO;
import com.callor.jdbc.persistance.CompDao;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Repository("compDaoV1")
public class CompDaoImplV1 implements CompDao{

	protected final JdbcTemplate jdbcTemplate;

	public CompDaoImplV1(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	@Override
	public List<CompanyVO> selectAll() {

		String sql = "select * from tbl_company";
		List<CompanyVO> compList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<CompanyVO>(CompanyVO.class));
		log.debug("Comp Select {} ", compList.toString());
		return null;
	}

	@Override
	public CompanyVO findById(String pk) {
		// TODO Auto-generated method stub
		String sql = "select * from tbl_company ";
		sql += "where cp_code = ? ";
		Object[] params = new Object[] {pk};
		CompanyVO vo = (CompanyVO) jdbcTemplate.query(sql,params, new BeanPropertyRowMapper<CompanyVO>(CompanyVO.class));
		return null;
	}

	@Override
	public int insert(CompanyVO vo) {
		// TODO Auto-generated method stub
		String sql = "insert into tbl_company ";
		sql += " (cp_code, cp_title, cp_ceo, cp_addr, cp_tel) ";
		sql += " values(?,?,?,?,?) ";
		
		Object[] params = new Object[] {vo.getCp_code(), vo.getCp_title(), vo.getCp_ceo(),vo.getCp_addr(),vo.getCp_tel()};
		
		return jdbcTemplate.update(sql, params);
		
		
		
		
	}

	@Override
	public int update(CompanyVO vo) {
		// TODO Auto-generated method stub
		String sql = "update tbl_company set ";
		sql += " cp_title = ? , cp_ceo = ? , cp_addr = ? , cp_tel = ?  ";
		sql += " where cp_code = ? ";
		
		Object[] params = new Object[] {vo.getCp_title(), vo.getCp_ceo(), vo.getCp_addr(), vo.getCp_tel(),vo.getCp_code()};
		
		return jdbcTemplate.update(sql, params);
	}

	@Override
	public int delete(String pk) {
		// TODO Auto-generated method stub
		String sql = "delete from tbl_company ";
		sql += " where cp_code = ? ";
		
		Object[] params = new Object[] {pk};
		
		return jdbcTemplate.update(sql, params);
	}

	@Override
	public List<CompanyVO> findByCName(String name) {
		// TODO Auto-generated method stub
		
		String sql = "select * from tbl_company ";
		sql += "where cp_title = ? ";
		Object[] params = new Object[] {name};
		CompanyVO vo = (CompanyVO) jdbcTemplate.query(sql,params, new BeanPropertyRowMapper<CompanyVO>(CompanyVO.class));
		
		return null;
	}


	@Override
	public List<CompanyVO> findByTel(String tel) {
		// TODO Auto-generated method stub
		
		String sql = "select * from tbl_company ";
		sql += "where cp_tel = ? ";
		Object[] params = new Object[] {tel};
		CompanyVO vo = (CompanyVO) jdbcTemplate.query(sql,params, new BeanPropertyRowMapper<CompanyVO>(CompanyVO.class));
		
		return null;
	}


	@Override
	public List<CompanyVO> findByCeo(String ceo) {
		// TODO Auto-generated method stub
		String sql = "select * from tbl_company ";
		sql += "where cp_ceo = ? ";
		Object[] params = new Object[] {ceo};
		CompanyVO vo = (CompanyVO) jdbcTemplate.query(sql,params, new BeanPropertyRowMapper<CompanyVO>(CompanyVO.class));
		return null;
	}

}
