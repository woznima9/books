package dao;

import model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao {
    List<Book> findAll() throws Exception;

}
