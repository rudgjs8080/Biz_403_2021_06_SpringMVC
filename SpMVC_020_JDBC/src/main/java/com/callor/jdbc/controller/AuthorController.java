package com.callor.jdbc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.jdbc.model.AuthorVO;
import com.callor.jdbc.model.UserVO;
import com.callor.jdbc.service.AuthorService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/author")
public class AuthorController {
	
	protected final AuthorService auService;
	public AuthorController(AuthorService auService) {
		// TODO Auto-generated constructor stub
		this.auService = auService;
	}
	
	@RequestMapping(value= {"/",""}, method=RequestMethod.GET)
	public String list(HttpSession hSession, Model model) {
		
		UserVO userVO = (UserVO)hSession.getAttribute("USERVO");
		if(userVO == null) {
			model.addAttribute("MSG", "LOGIN");
			return "redirect:/member/login";
			
		}
		List<AuthorVO> auList = auService.selectAll();
		model.addAttribute("AUTHORS", auList);
		log.debug(auList.toString());
		return "author/list";
	}
	
	
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insert() {
		
		return "author/input";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update() {
		
		
		return "author/input";
	}
}
