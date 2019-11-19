package com.springmvc.angular.bookapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.angular.bookapi.dao.BookDao;
import com.springmvc.angular.bookapi.model.Book;

@Service
@Transactional(readOnly = true)
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDAO;
	
	@Transactional
	@Override
	public long save(Book book) {
		return bookDAO.save(book);
	}

	@Override
	public Book get(long id) {
		return bookDAO.get(id);
	}

	@Override
	public List<Book> list() {
		return bookDAO.list();
	}

	@Override
	@Transactional
	public void update(long id, Book book) {
		bookDAO.update(id, book);
	}

	@Override
	@Transactional
	public void delete(long id) {
		bookDAO.delete(id);
	}

}
