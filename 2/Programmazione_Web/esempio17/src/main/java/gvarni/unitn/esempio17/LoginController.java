package gvarni.unitn.esempio17;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final LoggedUserManagement loggedUserManagement;
    private final ValidationService validationService;
    private final LoginCounterService logincounterservice;

    @Autowired
    LoginController(LoggedUserManagement loggedUserManagement, ValidationService validationService, LoginCounterService logincounterservice) {
        this.loggedUserManagement = loggedUserManagement;
        this.validationService = validationService;
        this.logincounterservice = logincounterservice;
    }


    @GetMapping("/index")
    public String index(Model model) {
        loggedUserManagement.setUsername(null); //lo metto per far creare bean di sessione e cosi vedo cookies in home.
        int counter = logincounterservice.getCounter();
        model.addAttribute("counter", counter );
        return "index";
    }

    @PostMapping("/validation")
    public String validation(@RequestParam String username, @RequestParam String password, Model model) {
        validationService.setUsername(username);
        validationService.setPassword(password);

        if (validationService.validation()) {
            loggedUserManagement.setUsername(username); //metto in sessione per poter passare dato ad altri controller
            logincounterservice.incrementCounter();

            model.addAttribute("name", username); // metto nel model per passarlo alla view

            return ("dashboard");
        } else
            return ("failure");


    }
}
