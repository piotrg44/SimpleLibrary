package pl.giczewski.form_with_displaying_data_and_mysql_database.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.giczewski.form_with_displaying_data_and_mysql_database.Model.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book b WHERE CONCAT( b.title, b.author) LIKE %?1%")
    public List<Book> findAllByKeyword(String keyword);
}
