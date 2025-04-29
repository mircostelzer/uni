package test.rest_demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(
    name = "DateTime",
        url = "${name.service.url}"
)

public interface DateTimeProxy {
    @GetMapping("/api/time/current/zone")
    DateTime getDateTime(@RequestParam("timeZone") String timeZone);

    @GetMapping("api/timezone/availabletimezones")
    List<String> getTimeZones();

}
