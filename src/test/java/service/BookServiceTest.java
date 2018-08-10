package service;

import bookstore.SpringConfig;
import bookstore.dao.BookDao;
import bookstore.model.Book;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import bookstore.service.BookService;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class BookServiceTest {
    @Test
    public void getBooksLent30DaysAgo() throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookService bookService = ctx.getBean(BookService.class);

        List<Book> booksLent30DaysAgo = bookService.findBooksLent30DaysAgo();
        System.out.println(booksLent30DaysAgo.get(0).getTitle());
        assertEquals(2, booksLent30DaysAgo.size());
        assertEquals("Spring in Action", booksLent30DaysAgo.get(0).getTitle());
        assertEquals("Spring in Practice", booksLent30DaysAgo.get(1).getTitle());
    }

    @Test
    public void dajZnak() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookService bookService = ctx.getBean(BookService.class);
        bookService.dajZnak();

    }


}
