package gvarni.unitn.esempio21;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    @GetMapping("/france")
    public String france() {
        return "France 57";
    }


    @GetMapping("/italy")
    public Country italy() {
        Country c = new Country("Italy", 56);
        return c;
    }
}
