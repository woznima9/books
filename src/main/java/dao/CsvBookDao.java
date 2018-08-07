package dao;

import model.Book;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class CsvBookDao implements BookDao {
    private String csvBooksFile;

    public void setCsvBooksFile(String csvBooksFile) {
        this.csvBooksFile = csvBooksFile;
    }

    public List<Book> findAll() throws Exception {
        List<Book> booksList = new ArrayList<Book>();
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(csvBooksFile));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] fields = line.split(",");
            String title = fields[0];
            String author = fields[1];
            Date lendDate = dateFormat.parse(fields[2]);
            Book book = new Book(title, author, lendDate);
            booksList.add(book);
        }
        bufferedReader.close();
        return booksList;
    }


}
