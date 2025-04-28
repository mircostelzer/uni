package com.example.openfeign0B;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class DateAndTimeController {
    private final DateAndTimeProxy dateAndTimeProxy;

    public DateAndTimeController(DateAndTimeProxy dateAndTimeProxy) {
        this.dateAndTimeProxy = dateAndTimeProxy;
    }

    @GetMapping("/")
    public String index(Model model) {
        String date = dateAndTimeProxy.getDate();
        String time = dateAndTimeProxy.getTime();
        model.addAttribute("date", date);
        model.addAttribute("time", time);
        return "index";
    }
}
