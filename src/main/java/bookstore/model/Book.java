package bookstore.model;

import org.springframework.stereotype.Service;

import java.util.Date;

public class Book {
    private String title;
    private String author;
    private Date lendDate;

    public Book(String title, String author, Date lendDate) {
        this.title = title;
        this.author = author;
        this.lendDate = lendDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getLendDate() {
        return lendDate;
    }

    public void setLendDate(Date lendDate) {
        this.lendDate = lendDate;
    }
}

