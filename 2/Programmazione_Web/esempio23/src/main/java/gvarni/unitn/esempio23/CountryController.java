package gvarni.unitn.esempio23;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    @GetMapping(value = "/france")
    public Country france() {
        Country c = new Country("France", 67);
        return c;
    }


    @PostMapping("/test")
    public Country test(@RequestBody Country a) {
        Country c = new Country(a.getName(), a.getPopulation());
        return c;
    }

}

