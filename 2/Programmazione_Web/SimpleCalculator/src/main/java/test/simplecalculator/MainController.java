package test.simplecalculator;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String index(HttpServletRequest request, HttpServletResponse response, Model model) {
        Cookie[] cookies = request.getCookies();
        boolean found = false;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("name")) {
                    found = true;
                    model.addAttribute("name", cookie.getValue());
                }
            }
        }

        if (!found) {
            Cookie newCookie = new Cookie("name", "user");
            newCookie.setMaxAge(60 * 60 * 24);
            response.addCookie(newCookie);
        }

        return "index";
    }
}
