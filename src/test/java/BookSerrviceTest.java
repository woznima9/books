import dao.BookDao;
import model.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.BookService;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class BookSerrviceTest {
    @Test
    public void getBooksLent30DaysAgo() throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = (BookService) ctx.getBean("bookService");
        List<Book> booksLent30DaysAgo = bookService.findBooksLent30DaysAgo();
        System.out.println(booksLent30DaysAgo.get(0));
        assertEquals(1, booksLent30DaysAgo.get(0).getTitle());


    }

    @Test
    public void getCsvBookDao() {
        BookDao bookDao = new BookDao() {
            public List<Book> findAll() throws Exception {
                return null;
            }
        };

    }

}
