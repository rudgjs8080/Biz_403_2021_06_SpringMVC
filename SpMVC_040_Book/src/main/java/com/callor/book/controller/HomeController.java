package com.callor.book.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.book.model.BookDTO;
import com.callor.book.service.NaverService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class HomeController {
	
	protected final NaverService<BookDTO> nBookService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(@RequestParam(name="search", required = false, defaultValue = "" ) String search, Model model) {
		
		if(search != null && !search.equals("")) {
			String queryURL = nBookService.queryURL(search.trim());
			String jsonString = nBookService.getJsonString(queryURL);
			List<BookDTO> bookList = nBookService.getNaverList(jsonString);
			model.addAttribute("BOOKS",bookList);
		}
		
		return "home";
	}
	
}
