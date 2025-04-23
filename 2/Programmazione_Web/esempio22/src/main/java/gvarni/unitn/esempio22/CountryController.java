package gvarni.unitn.esempio22;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    @GetMapping(value = "/france", produces = MediaType.APPLICATION_XML_VALUE)
    public Country france() {
        Country c = new Country("France", 67);
        return c;
    }

}


//, produces = MediaType.APPLICATION_XML_VALUE