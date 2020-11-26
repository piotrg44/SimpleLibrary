package pl.giczewski.form_with_displaying_data_and_mysql_database.Service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.giczewski.form_with_displaying_data_and_mysql_database.Repository.UserRepository;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {

    UserRepository userRepository;

    public UserDetailsServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.getByUsername(s);
    }
}
