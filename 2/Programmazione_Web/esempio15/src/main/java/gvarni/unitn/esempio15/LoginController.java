package gvarni.unitn.esempio15;


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
    private final LoginCounterService loginCounterService;

    @Autowired
    LoginController(LoggedUserManagement loggedUserManagement, ValidationService validationService, LoginCounterService loginCounterService) {
        this.loggedUserManagement = loggedUserManagement;
        this.validationService = validationService;
        this.loginCounterService = loginCounterService;
    };

    @GetMapping("/")
    public String index()
    {   //loggedUserManagement.setUsername(null); //lo metto per far creare bean di sessione e cosi vedo cookies in home.
        if (loggedUserManagement != null) {
            System.out.println("Session Bean initialized");
        }
        return "index";}

    @PostMapping("/validation")
    public String validation(@RequestParam String username,
                             @RequestParam String password, Model model){


        if (validationService.isValid(username, password)) {
            loginCounterService.increment();
            System.out.println("Counter: " + loginCounterService.getCounter());
            loggedUserManagement.setUsername(username); //metto in sessione per poter passare dato ad altri controller
            model.addAttribute("name", username); // metto nel model per passarlo alla view
            return ("dashboard");
        }

        else
            return ("failure");

    }


}
