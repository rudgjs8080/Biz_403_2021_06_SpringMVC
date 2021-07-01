package com.callor.book.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.callor.book.config.NaverQualifier;
import com.callor.book.model.BookDTO;
import com.callor.book.model.MovieDTO;
import com.callor.book.model.NewsDTO;
import com.callor.book.service.NaverAbstractService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service(NaverQualifier.NAVER_MAIN_SERVICE_V1)
@RequiredArgsConstructor
public class NaverMainService {

	@Qualifier(NaverQualifier.NAVER_BOOK_SERVICE_V1)
	protected final NaverAbstractService<BookDTO> nBookService;
	@Qualifier(NaverQualifier.NAVER_MOVIE_SERVICE_V1)
	protected final NaverAbstractService<MovieDTO> nMovieService;
	@Qualifier(NaverQualifier.NAVER_NEWS_SERVICE_V1)
	protected final NaverAbstractService<NewsDTO> nNewsService;

	public void naverGetData(String cat, String search, Model model) throws IOException {

		if (search != null && !search.equals("")) {

			if (cat.equalsIgnoreCase("BOOK")) {
				// 도서 검색 서비스
				// Controller가 할 일을 Service가 대신하기 
				String queryURL = nBookService.queryURL(search);
				String jSonString = nBookService.getJsonString(queryURL);
				List<BookDTO> books = nBookService.getNaverList(jSonString);
				model.addAttribute("BOOKS", books);

			} else if (cat.equalsIgnoreCase("NEWS")) {
				// 뉴스 검색 서비스
				String queryURL = nNewsService.queryURL(search.trim());
				String jsonString = nNewsService.getJsonString(queryURL);
				List<NewsDTO> newsList = nNewsService.getNaverList(jsonString);
				model.addAttribute("NEWS_LIST", newsList);

			} else if (cat.equalsIgnoreCase("MOVIE")) {
				// 영화 검색 서비스
				String queryURL = nMovieService.queryURL(search.trim());
				String jsonString = nMovieService.getJsonString(queryURL);
				List<MovieDTO> mvList = nMovieService.getNaverList(jsonString);
				model.addAttribute("MOVIES", mvList);

			}
		}

	}

}
