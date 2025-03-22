package gvarni.unitn.esempio8;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormHandler {

    @RequestMapping("/home")
    public String home()
    {return "home";}

    @GetMapping("/submit")
    public String receiveFormDatafromGet(@RequestParam("firstName") String firstName,
                                  @RequestParam("lastName") String lastName,
                                  Model model) {

        return processRequest(firstName, lastName, model);
    }

    @PostMapping("/submit")
    public String receiveFormDatafromPost(@RequestParam("firstName") String firstName,
                                  @RequestParam("lastName") String lastName,
                                  Model model) {

        return processRequest(firstName, lastName, model);
    }

    private String processRequest (String firstName, String lastName, Model model) {
        model.addAttribute("firstName", firstName);
        model.addAttribute("lastName", lastName);

        return "result";

    }

}
