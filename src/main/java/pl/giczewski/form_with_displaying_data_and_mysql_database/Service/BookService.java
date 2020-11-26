package pl.giczewski.form_with_displaying_data_and_mysql_database.Service;

import org.springframework.stereotype.Service;
import pl.giczewski.form_with_displaying_data_and_mysql_database.Model.Book;
import pl.giczewski.form_with_displaying_data_and_mysql_database.Repository.BookRepository;

import java.util.List;

@Service
public class BookService {
    BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public List<Book> findAll(String keyword) {
        return bookRepository.findAllByKeyword(keyword);
    }


}
