package beans;

public class Owner {

    private String name;
    private Parrot parrot;

    public Owner(Parrot parrot){
        this.parrot = parrot;
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parrot getParrot() {
        return parrot;
    }

    public void setParrot(Parrot parrot) {
        this.parrot = parrot;
    }
}

