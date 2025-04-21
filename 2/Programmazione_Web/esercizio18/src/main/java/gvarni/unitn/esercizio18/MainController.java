package gvarni.unitn.esercizio18;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    private final UtenteRepository utenteRepository;

    private MainController(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/table")
        public String table(Model model){
        List<Utente> lu = utenteRepository.getUtenti();
        model.addAttribute("utente", lu);

        return ("table");
    }
}
