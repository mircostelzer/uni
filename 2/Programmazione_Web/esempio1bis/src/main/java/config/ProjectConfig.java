package config;

import introweb.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    Parrot parrot1() {
        var p = new Parrot();
        p.setName("First");
        return p;
    }

    @Bean
    String greetings(){
        return "Hello!";
    }

    @Bean
    Integer five(){
        return 5;
    }


    @Bean
    Parrot parrot2() {
        var p = new Parrot();
        p.setName("Second");
        return p;
    }

    @Bean
    Parrot parrot3() {
        var p = new Parrot();
        p.setName("Third");
        return p;
    }
}

