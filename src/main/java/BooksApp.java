import model.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.BookService;

import java.util.List;

public class BooksApp {
    public static void main(String[] args) throws Exception {
//        AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookService bookService = (BookService) ctx.getBean("bookService");
        List<Book> booksLent30DaysAgo = bookService.findBooksLent30DaysAgo();
    }

}
