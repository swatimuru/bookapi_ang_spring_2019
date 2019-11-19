package com.springmvc.angular.bookapi.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvc.angular.bookapi.model.Book;

@Repository
public class BookDaoImpl implements BookDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public long save(Book book) {
		sessionFactory.getCurrentSession().save(book);
	    return book.getId();
	}

	@Override
	public Book get(long id) {
		return sessionFactory.getCurrentSession().get(Book.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> list() {
		return sessionFactory.getCurrentSession().createQuery("from Book").list();
	}

	@Override
	public void update(long id, Book book) {
		Session session = sessionFactory.getCurrentSession();
	    Book book2 = session.byId(Book.class).load(id);
	    book2.setTitle(book.getTitle());
	    book2.setAuthor(book.getAuthor());
	    session.flush();
	}

	@Override
	public void delete(long id) {
		Book book = sessionFactory.getCurrentSession().byId(Book.class).load(id);
	    sessionFactory.getCurrentSession().delete(book);
	}

}
