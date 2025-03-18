package introweb;

import beans.Owner;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Owner o = context.getBean(Owner.class);

        System.out.println("Person's name: " + o.getName());
        System.out.println("Person's parrot: " + o.getParrot().getName());
    }
}
