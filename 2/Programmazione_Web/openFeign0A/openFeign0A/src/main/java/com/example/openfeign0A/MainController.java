package com.example.openfeign0A;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private final DateTimeService dateTimeService;

    public MainController(DateTimeService dateTimeService) {
        this.dateTimeService = dateTimeService;
    }

    @GetMapping("/date")
    String getDate() {
        return dateTimeService.getDate();
    }

    @GetMapping("/time")
    String getTime() {
        return dateTimeService.getTime();
    }
}