package gvarni.unitn.esempio15;

import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class LoggedUserManagement {

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("Cleaning up resources for the session");
        // Release any resources held by this bean
    }

}