package test.rest_demo;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class TimeZoneSession {
    private String timeZone;

    public TimeZoneSession() {
        this.timeZone = "Europe/Rome";
    }

    public String getTimeZone() {
        return timeZone;
    }
    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }
}
