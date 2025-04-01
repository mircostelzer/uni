package gvarni.unitn.esempio9bis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.boot.builder.SpringApplicationBuilder;


@SpringBootApplication
public class Esempio9bisApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Esempio9bisApplication.class, args);
    }


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Esempio9bisApplication.class);
    }


}
