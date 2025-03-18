package beans;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class Owner {

    private String name = "Paolino";

    private final Parrot parrot; //final means that the instance of parrot cannot be changed

    @Autowired
    public Owner(Parrot parrot) {
        this.parrot = parrot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parrot getParrot() {
        return parrot;
    }

}
