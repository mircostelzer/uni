package gvarni.unitn.esempio15;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

@Service
@RequestScope
public class ValidationService {

    public boolean isValid(String username, String password) {
        return "giovanna".equals(username) && "admin".equals(password);
    }
}
