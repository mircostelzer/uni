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

    @Autowired
    LoginController(LoggedUserManagement loggedUserManagement){
        this.loggedUserManagement = loggedUserManagement;
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


        if ("giovanna".equals(username) && "admin".equals(password)) {
            loggedUserManagement.setUsername(username); //metto in sessione per poter passare dato ad altri controller
            model.addAttribute("name", username); // metto nel model per passarlo alla view
            return ("dashboard");
        }

        else
            return ("failure");

    }


}
