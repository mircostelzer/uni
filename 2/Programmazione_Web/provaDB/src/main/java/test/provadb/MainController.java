package test.provadb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainController {
    private final UsersRepository usersRepository;

    @Autowired
    public MainController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @RequestMapping({"/"})
    public String index() {
        return "index";
    }

    @GetMapping({"/table"})
    public String users(Model model) {
        List<User> users = this.usersRepository.getUsers();
        model.addAttribute("users", users);
        return "table";
    }

}
