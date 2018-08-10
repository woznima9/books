package bookstore;

import bookstore.dao.BookDao;
import bookstore.model.Book;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import bookstore.service.BookService;

import java.util.List;


public class SpringStarter {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookService bookService = ctx.getBean(BookService.class);
        bookService.dajZnak();
        List<Book> booksLent30DaysAgo = bookService.findBooksLent30DaysAgo();
        System.out.println(booksLent30DaysAgo.get(0).getTitle());


    }

}
