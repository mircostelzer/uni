package com.example.openfeign0B;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "dateAndTime",
             url = "${name.service.url}")
public interface DateAndTimeProxy {
    @GetMapping("/date")
    String getDate();

    @GetMapping("/time")
    String getTime();
}

