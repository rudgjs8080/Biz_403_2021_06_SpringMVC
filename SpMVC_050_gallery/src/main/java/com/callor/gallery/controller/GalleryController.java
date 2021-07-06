package com.callor.gallery.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.gallery.model.GalleryDTO;
import com.callor.gallery.service.GalleryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Controller
@RequestMapping(value = "/gallery")
public class GalleryController {

	protected final GalleryService gService;
	
	@RequestMapping(value= {"/",""}, method=RequestMethod.GET)
	public String list(Model model) throws Exception {
		
		List<GalleryDTO> gList = gService.selectAll();
		model.addAttribute("GALLERYS",gList);
		model.addAttribute("BODY", "GA-LIST");
		
		return "home";
	}
	
	
	@RequestMapping(value = "/input", method = RequestMethod.GET)
	public String input(Model model) {

		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat st = new SimpleDateFormat("hh:mm:ss");

		String curDate = sd.format(date);
		String curTime = st.format(date);

		GalleryDTO gDTO = GalleryDTO.builder().g_date(curDate).g_time(curTime).g_writer("Key").build();

		model.addAttribute("CMD", gDTO);
		model.addAttribute("BODY", "GA-INPUT");

		return "home";
	}
	/*
	 * BODY를 왜 사용하는지?
	 * 
	 * builder로 설계하는 이유
	 * 필요한 DTO만 만들어서 사용할 수 있다
	 * 위에서 보면 날짜 시간 작성자만 만들어서 사용하는 것을 볼 수 있다
	 * 
	 */
	
	@RequestMapping(value="/input", method=RequestMethod.POST)
	public String input(GalleryDTO gDTO, 
			MultipartFile one_file,
			MultipartHttpServletRequest m_file,
			Model model) throws Exception {
		
		log.debug("갤러리 정보 {}",gDTO.toString());
		log.debug("싱글파일 {}", one_file.getOriginalFilename());
		log.debug("멀티파일 {}", m_file.getContentType());
		
		gService.input(gDTO, one_file, m_file);
		
		
		
		return "redirect:/gallery";
	}
	
	
}
