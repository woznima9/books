package bookstore.dao;

import bookstore.model.Book;

import java.util.List;

public interface BookDao {
    List<Book> findAll() throws Exception;

}
