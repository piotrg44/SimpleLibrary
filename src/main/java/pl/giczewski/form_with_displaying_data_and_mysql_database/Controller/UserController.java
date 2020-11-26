package pl.giczewski.form_with_displaying_data_and_mysql_database.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.giczewski.form_with_displaying_data_and_mysql_database.Model.User;
import pl.giczewski.form_with_displaying_data_and_mysql_database.Service.UserService;

@Controller
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/addUser")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register_form_user";
    }

    @PostMapping("/register_user")
    public String submitForm(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "home";
    }

}
