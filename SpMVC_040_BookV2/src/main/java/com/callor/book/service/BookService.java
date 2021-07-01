package com.callor.book.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public interface BookService {

	public int insert(String isbn) throws UnsupportedEncodingException, IOException;

}
