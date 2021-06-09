package com.callor.jdbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.jdbc.model.CompanyVO;
import com.callor.jdbc.persistance.CompDao;
import com.callor.jdbc.service.CompService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/comp")
public class CompController {
	
	protected final CompDao compDao;
	protected final CompService compService;
	public CompController(CompDao compDao, CompService compService) {
		this.compDao = compDao;
		this.compService = compService;
		
	}
	
	// localhost:8080/jdbc/comp/insert로 호출되는 함수
	@RequestMapping(value="/insert" , method=RequestMethod.GET)
	public String insert() {
		
		
		// WEB-INF/views/comp/input.jsp를 열어라
		return "comp/input";
	}
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(CompanyVO cmVO) {
		
		log.debug("companyVO {}", cmVO.toString());
		compService.insert(cmVO);
		
		return "redirect:/";
	}
	
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update() {
		
		return "comp/input";
	}
	// @RequestParam("pk") ??  
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(String pk) {
		
		compDao.delete(pk); 
		return "redirect:/";
	}
	
}
