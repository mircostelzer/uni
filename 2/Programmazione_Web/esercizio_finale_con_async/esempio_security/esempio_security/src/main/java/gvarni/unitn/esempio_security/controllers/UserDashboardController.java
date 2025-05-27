package gvarni.unitn.esempio_security.controllers;

import gvarni.unitn.esempio_security.services.DateTimeService;
import gvarni.unitn.esempio_security.services.ExternalDateTimeService;
import gvarni.unitn.esempio_security.services.RandomGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserDashboardController {
    private final RandomGeneratorService random;
    private final DateTimeService date;
    private final ExternalDateTimeService externalDateTimeService;

    @Autowired
   public UserDashboardController(RandomGeneratorService random,
                               DateTimeService date,
                               ExternalDateTimeService externalDateTimeService) {
        this.random = random;
        this.date = date;
        this.externalDateTimeService = externalDateTimeService;
    }

    @GetMapping("/compute")
    public String compute(Authentication authentication, Model model) {
        String name = authentication.getName();
        if (name != null) {
            model.addAttribute("name",name);
            model.addAttribute("number", random.getNumber());
            return ("userDashboard");}
        else
            return ("index");
    }

    @GetMapping("/datetime")
    public String datetime(Authentication authentication, Model model) {
        String name = authentication.getName();
        if (name != null) {
            model.addAttribute("name",name);
            model.addAttribute("date", date.getDate());
            model.addAttribute("time", date.getTime());
            return ("userDashboard");}
        else
            return ("index");

    }

    @GetMapping("/externalDateTime")
    public String externalDatetime(Authentication authentication, Model model) {
        String name = authentication.getName();
        if (name != null) {
            model.addAttribute("name",name);
            model.addAttribute("externalDate", externalDateTimeService.getDate());
            model.addAttribute("externalTime", externalDateTimeService.getTime());
            return ("userDashboard");}
        else
            return ("index");
    }

}
