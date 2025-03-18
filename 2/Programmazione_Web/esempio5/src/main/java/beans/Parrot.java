package beans;

import org.springframework.stereotype.Component;

@Component
public class Parrot {

    private String parrot_name = "Cocorita";

    public String getName() {
        return parrot_name;
    }

    public void setName(String name) {
        this.parrot_name = parrot_name;
    }

}
