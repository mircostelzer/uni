package test.rest_demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DateTimeController {

    private final DateTimeProxy dateTimeProxy;

    @Autowired
    public DateTimeController(DateTimeProxy dateTimeProxy) {
        this.dateTimeProxy = dateTimeProxy;
    }

    @GetMapping({"/"})
    String index(Model model) {
        DateTime dateTime = dateTimeProxy.getDateTime("Europe/Rome");
        model.addAttribute("timezone", dateTime.getTimeZone());
        model.addAttribute("date", dateTime.getDay() + "/" + dateTime.getMonth() + "/" + dateTime.getYear());
        model.addAttribute("time", dateTime.getHour() + ":" + dateTime.getMinute() + ":" + dateTime.getSeconds());
        return "index";
    }
}
