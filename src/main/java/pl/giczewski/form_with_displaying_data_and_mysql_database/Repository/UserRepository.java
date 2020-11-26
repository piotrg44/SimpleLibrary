package pl.giczewski.form_with_displaying_data_and_mysql_database.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.giczewski.form_with_displaying_data_and_mysql_database.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    public User getByUsername(String username);
}
