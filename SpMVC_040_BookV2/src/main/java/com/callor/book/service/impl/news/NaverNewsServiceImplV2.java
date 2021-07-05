package com.callor.book.service.impl.news;

import java.net.URI;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.callor.book.config.NaverQualifier;
import com.callor.book.config.NaverSecret;
import com.callor.book.model.NaverParentDTO;
import com.callor.book.model.NewsDTO;

import lombok.extern.slf4j.Slf4j;
/*
 * spring framework의 RestTemplate 클래스를 사용한
 * JSON parsing
 * 
 * json-simple, Gson등을 사용할 때는
 * OpenAPI를 통하여 JsonString을 수신하고
 * parsing을 통해 DTO, List<DTO>형태의 데이터로 변환하는 과정을 수행했다
 * 
 * RestTemplate을 사용하면
 * DTO(VO)의 겹치는 구조를 잘 설계하고
 * 
 * 요청 주소를 URI로 생성하고
 * 인증정보등을 HttpHeaders 클래스로 설정하고
 * HttpEntity로 변환하여 RestTemplate에 주입한다
 * 
 * 또한, DTO(VO)의 parent 클래스를 매개변수로 보내어 데이터를
 * parsing 하도록 한다
 * 
 * 내부에서 발생한 요청정보를 Open API로 보내고
 * 수신된 데이터를 DTO(VO) 구조에 따라 자체 parsing을 하고
 * 결과를 돌려준다
 * 
 * DTO에 겹치는 부분을 잘 설계해야한다 !!
 */
@Slf4j
@Service(NaverQualifier.NAVER_NEWS_SERVICE_V2)
public class NaverNewsServiceImplV2 extends NaverNewsServiceImplV1 {

	

	@Override
	public List<NewsDTO> getNaverList(String queryURL) throws Exception {
		// TODO Auto-generated method stub

		// Spring framework 3.2에서 처음 도입된 클래스
		RestTemplate restTemp = new RestTemplate();
		// RestTemplate통해 수신된 데이터를
		// 자동 parsing하기 위한 클래스 
		
		ResponseEntity<NaverParentDTO> resList = null;
		// OpenAPI에 요청을 하기 위한 클래스
		
		/*
		 * json-simple, Gson 등으로 parsing을 수행할 때는
		 * URL 클래스를 사용하여 naver에 요청하고
		 * 결과를 jsonString 으로 받았다
		 * 
		 * URI 클래스를 사용하여 naver에 요청하는 정보를 생성하기
		 * 내부적으로 인코딩 등의 문제를 없애기 위해
		 * URL을 사용하지 않고 URI를 사용한다
		 */
		URI restURI = new URI(queryURL);
		
		HttpHeaders header = new HttpHeaders();
		header.set("X-Naver-Client-Id", NaverSecret.NAVER_CLIENT_ID);
		header.set("X-Naver-Client-Secret", NaverSecret.NAVER_CLIENT_SECRET);
		header.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
		HttpEntity<String> entity = new HttpEntity<String>("parameter",header); // parameter라는 이름으로 주입
		
		resList = restTemp.exchange(restURI, // naver에 요청할 URL 정보
				HttpMethod.GET, // GET method로 요청
				entity, // 인증정보등이 담긴 header
				NaverParentDTO.class);// 내가 받을 데이터
		log.debug("업데이트 날짜 {}", resList.getBody().lastBuildDate);
		log.debug("전체 개수 {}", resList.getBody().total);
		log.debug("리스트 {}", resList.getBody().items.toString());
		
		List<NewsDTO> movie = resList.getBody().items;
		return movie;
	}

}
