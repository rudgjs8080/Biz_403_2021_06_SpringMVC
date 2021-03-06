package com.callor.woo.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.woo.model.AddrDTO;
import com.callor.woo.model.AddrVO;
import com.callor.woo.model.WeatherDTO;
import com.callor.woo.model.WeatherVO;
import com.callor.woo.service.DaySelectService;
import com.callor.woo.service.NaverService;
import com.callor.woo.service.TimeService;
import com.callor.woo.service.WeatherService;
import com.google.protobuf.TextFormat.ParseException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class APIController {

	@Qualifier("naverService")
	protected final NaverService nService;

	@Qualifier("weatherService")
	protected final WeatherService wService;

	@Qualifier("dayService")
	protected final DaySelectService dService;
	
	@Qualifier("timeService")
	protected final TimeService tService;

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String home(@RequestParam("lat") String latitude, @RequestParam("lng") String longitude, Model model)
			throws MalformedURLException, IOException, ParseException, org.json.simple.parser.ParseException {

		log.debug("lat {}", latitude);
		log.debug("lng {}", longitude);

		String url = nService.queryURL(latitude, longitude);
		String jsonString = nService.getJsonString(url);
		List<AddrDTO> addrList = nService.getAddrList(jsonString);

		log.debug(addrList.toString());
		String addr = "";
		for (int i = 1; i < 4; i++) {
			addr += addrList.get(i).getName();
		}
		
		log.debug("String addr {}", addr.trim());

		List<AddrVO> location = nService.findByAddr(addr);
<<<<<<< HEAD
		AddrVO locations = location.get(0);
		String location_addr = locations.getAr_addr();
		
		log.debug("locations {}", locations);
=======

		log.debug("location {}", location);
>>>>>>> 51514b0ec0ca5a244ac3e26cec7db31cf7b601ce

		Date date = new Date();

		SimpleDateFormat dt = new SimpleDateFormat("yyyyMMdd");

		String day = dt.format(date);

		/*
		int int_day = Integer.valueOf(day);
		int day_2 = int_day -1;
		String day1 = String.valueOf(day_2);
		*/

		String queryURL = wService.queryURL(location, day);
		String weatherString = wService.getJsonString(queryURL);
		List<WeatherVO> weatherVO = wService.getWeatherList(weatherString);

		log.debug("?????? ?????? ????????? {} ", weatherVO.toString());

		Map weather = dService.gubun(day, weatherVO);

		List<WeatherDTO> today = (List<WeatherDTO>) weather.get("today");
		List<WeatherDTO> tomorrow = (List<WeatherDTO>) weather.get("tomorrow");
		List<WeatherDTO> afterTomorrow = (List<WeatherDTO>) weather.get("afterTomorrow");

		//		log.debug("???????????? ??? {}", weather.toString());
		//		log.debug("???????????? {}",today.toString());
				log.debug("???????????? {}",tomorrow.toString());
		//		log.debug("2???????????? {}",afterTomorrow.toString());

		String time = tService.time();
		
<<<<<<< HEAD
		//		log.debug("???????????? ??? {}", weather.toString());
		//		log.debug("???????????? {}",today.toString());
		//		log.debug("???????????? {}",tomorrow.toString());
		//		log.debug("2???????????? {}",afterTomorrow.toString());

		String time = tService.time();
		
		model.addAttribute("LOCATION",location_addr);
=======
		model.addAttribute("LOCATION",location);
>>>>>>> 51514b0ec0ca5a244ac3e26cec7db31cf7b601ce
		model.addAttribute("TIME", time);
		model.addAttribute("TODAY", today);
		model.addAttribute("TOMORROW", tomorrow);
		model.addAttribute("AFTERTOMORROW", afterTomorrow);
		return "home1";
	}
}
