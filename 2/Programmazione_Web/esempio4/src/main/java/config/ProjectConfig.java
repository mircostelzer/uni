package config;

import beans.Parrot;
import beans.Owner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    public Parrot parrot() {
        Parrot p = new Parrot();
        p.setName("Cocorita");
        return p;
    }

    @Bean
    public Owner person(Parrot parrot) {
        Owner o = new Owner(parrot);
        o.setName("Paolino");
        return o;
    }
}
