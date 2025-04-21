package gvarni.unitn.esempio16;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.RequestScope;

@Service
@RequestScope //per esercizio 16 commenta, per esercizio 17 scommenta
public class ValidationService {

    private String username;
    private String password;

    public void setUsername(String username) {this.username = username;}
    public void setPassword(String password) {this.password = password;}

    public String getUsername() {return this.username;}
    public String getPassword() {return this.password;}

    public boolean validation(){
        if ("giovanna".equals(this.username) && "admin".equals(this.password))
            return true;
        else
            return false;

    }

}
