package pl.giczewski.form_with_displaying_data_and_mysql_database.Controller;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.giczewski.form_with_displaying_data_and_mysql_database.Model.Book;
import pl.giczewski.form_with_displaying_data_and_mysql_database.Service.BookService;

import java.util.List;

@Controller
public class BookController {

    BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/addBooks")
    public String showBooks(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "register_form_book";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @PostMapping("/addBook")
    public String submitForm(@ModelAttribute("book") Book book) {
        bookService.addBook(book);
        return "register_success";
    }

    @RequestMapping("/allBooks")
    public String showAllBooks(Model model) {
//        List<Book> books = bookService.findAll();
//        model.addAttribute("book", books);
        return "list_of_books";
    }

    @RequestMapping("/allBooksByKeyword")
    public String showAllBooksByKeyword(Model model, @Param("keyword") String keyword) {
        List<Book> books = bookService.findAll(keyword);
        model.addAttribute("book", books);
        return "list_of_books";
    }
}
