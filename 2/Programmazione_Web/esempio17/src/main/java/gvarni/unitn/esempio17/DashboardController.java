package gvarni.unitn.esempio17;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    private final RandomGeneratorService random;
    private final DateTimeService date;
    private final LoggedUserManagement loggedUserManagement;
    private final LoginCounterService logincounterservice;
    private final HttpSession session;

    @Autowired
    public DashboardController(RandomGeneratorService random, DateTimeService date,
                               LoggedUserManagement loggedUserManagement, LoginCounterService logincounterservice, HttpSession session) {
        this.random = random;
        this.date = date;
        this.loggedUserManagement = loggedUserManagement;
        this.logincounterservice = logincounterservice;
        this.session = session;
    }

    @GetMapping("/compute")
    public String compute(Model model) {
        String name = loggedUserManagement.getUsername();
        if (name != null) {
            model.addAttribute("name",name);
            model.addAttribute("number", random.getNumber());
            return ("dashboard");}
        else
            return ("index");
    }

    @GetMapping("/datetime")
    public String datetime(Model model) {
        String name = loggedUserManagement.getUsername();
        if (name != null) {
            model.addAttribute("name",name);
            model.addAttribute("date", date.getDate());
            model.addAttribute("time", date.getTime());
            return ("dashboard");}
        else
            return ("index");

    }

    @GetMapping("/logout")
    public String logout(Model model) {
        int counter = logincounterservice.getCounter();
        model.addAttribute("counter", counter );
        loggedUserManagement.setUsername(null);
        session.invalidate();
        return ("index");
    }
}






