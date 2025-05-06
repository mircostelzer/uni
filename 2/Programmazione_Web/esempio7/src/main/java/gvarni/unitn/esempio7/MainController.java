package gvarni.unitn.esempio7;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class MainController {
    @RequestMapping("/")
    public String home(Model page){
        DateTimeFormatter day = DateTimeFormatter.ofPattern("dd/MM/yyy");
        DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        page.addAttribute("date",day.format(now));
        page.addAttribute("time",time.format(now));
        return "index";

    }
}