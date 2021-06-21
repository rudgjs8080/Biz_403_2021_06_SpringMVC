package com.callor.jdbc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.jdbc.model.AuthorVO;
import com.callor.jdbc.persistance.AuthorDao;
import com.callor.jdbc.service.AuthorService;

@Service("authorServiceV1")
public class AuthorServiceImplV1 implements AuthorService{

	@Autowired
	protected AuthorDao auDao;
	
	@Override
	public List<AuthorVO> selectAll() {
		// TODO Auto-generated method stub
		
		return auDao.selectAll();
	}

	@Override
	public AuthorVO findByACode(String au_code) {
		// TODO Auto-generated method stub
		return auDao.findById(au_code);
	}

	@Override
	public List<AuthorVO> findByAName(String au_name) {
		// TODO Auto-generated method stub
		return auDao.findByAName(au_name);
	}

	@Override
	public List<AuthorVO> findByATel(String au_tel) {
		// TODO Auto-generated method stub
		return auDao.findByATel(au_tel);
	}

}