package test.rest_demo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.TimeZone;

@Controller
public class DateTimeController {

    private final DateTimeProxy dateTimeProxy;
    private final TimeZoneSession timeZone;
    private final HttpSession session;

    @Autowired
    public DateTimeController(DateTimeProxy dateTimeProxy, TimeZoneSession timeZone, HttpSession session) {
        this.dateTimeProxy = dateTimeProxy;
        this.timeZone = timeZone;
        this.session = session;
    }

    @GetMapping({"/"})
    String index(Model model) {
        DateTime dateTime = dateTimeProxy.getDateTime(timeZone.getTimeZone());
        List<String> timeZones = dateTimeProxy.getTimeZones();
        model.addAttribute("timezone", dateTime.getTimeZone());
        model.addAttribute("date", dateTime.getDay() + "/" + dateTime.getMonth() + "/" + dateTime.getYear());
        model.addAttribute("time", dateTime.getHour() + ":" + dateTime.getMinute() + ":" + dateTime.getSeconds());
        model.addAttribute("timezones", timeZones);
        return "index";
    }

    @GetMapping({"/change"})
    String change(@RequestParam("timezones") String timeZones, Model model) {
        timeZone.setTimeZone(timeZones);
        return "forward:/";
    }

    @GetMapping({"/refresh"})
    String refresh(Model model) {
        this.session.invalidate();
        return "redirect:/";
    }
}
