package introweb;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Parrot {

    private String parrot_name;

    @PostConstruct
    public void init() {
        this.parrot_name = "Cocorita";
    }

    public String getName() {
        return parrot_name;
    }

    public void setName(String parrot_name) {
        this.parrot_name = parrot_name;
    }
}
