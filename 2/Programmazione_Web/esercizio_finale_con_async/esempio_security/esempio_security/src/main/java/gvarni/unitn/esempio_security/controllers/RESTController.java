package gvarni.unitn.esempio_security.controllers;

import gvarni.unitn.esempio_security.services.DateTimeService;
import gvarni.unitn.esempio_security.services.ExternalDateTimeService;
import gvarni.unitn.esempio_security.services.RandomGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTController {
    private final RandomGeneratorService random;

    @Autowired
    public RESTController(RandomGeneratorService random) {
        this.random = random;
    }

    @GetMapping("/getSequence")
    public String getSequence() {
        return String.valueOf(random.getNumber());
    }
}
