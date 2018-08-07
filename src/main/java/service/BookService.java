package service;

import dao.BookDao;
import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class BookService {
    @Autowired
    private BookDao bookDao;

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public List<Book> findBooksLent30DaysAgo() throws Exception {
        List<Book> booksLent30DaysAgo = new ArrayList<Book>();
        List<Book> allBooks = bookDao.findAll();

        Date thirtyDaysAgo = daysAgo(30);
        for (Book book : allBooks) {
            boolean bookWasLent30DaysAgo = book.getLendDate().compareTo(thirtyDaysAgo) <= 0;
            if (bookWasLent30DaysAgo) {
                booksLent30DaysAgo.add(book);
            }
        }
        return booksLent30DaysAgo;
    }

    private Date daysAgo(int days) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.add(Calendar.DATE, -days);
        return gregorianCalendar.getTime();
    }
}
