package gvarni.unitn.esercizio19;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @PostMapping("/storeuser")
    public String storeuser(@RequestParam String FirstName, @RequestParam String LastName, @RequestParam String username, @RequestParam String password){
    Utente u = new Utente();
    u.setNome(FirstName);
    u.setCognome(LastName);
    u.setUsername(username);
    u.setPassword(password);
    utenteRepository.storeUtente(u);

    return "home";
    }

}
