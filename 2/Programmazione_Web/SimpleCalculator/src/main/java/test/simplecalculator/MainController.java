package test.simplecalculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/game")
    public String gamePage() {
        return "game";
    }

    @PostMapping("/result")
    public String calculatePost(@RequestParam("firstOp") String firstOp,
                            @RequestParam("secondOp") String secondOp,
                            @RequestParam("op") String op,
                            Model model) {
        double res = calculate(firstOp, secondOp, op, model);

        if (model.getAttribute("result") == null) {
            model.addAttribute("result", res);
        }

        return "result";
    }

    @GetMapping("/result")
    public String calculateGet(@RequestParam("firstOp") String firstOp,
                            @RequestParam("secondOp") String secondOp,
                            @RequestParam("op") String op,
                            Model model) {
        double res = calculate(firstOp, secondOp, op, model);

        if (model.getAttribute("result") == null) {
            model.addAttribute("result", res);
        }

        return "result";
    }

    @GetMapping("/result/end")
    public String endPage() {
        return "end";
    }

    double calculate(String firstOp, String secondOp, String op, Model model) {
        double res = 0;
        switch (op) {
            case "+":
                try {
                    res = Double.parseDouble(firstOp) + Double.parseDouble(secondOp);
                } catch (NumberFormatException e) {
                    model.addAttribute("res","Error: " + e.getMessage());
                }
                break;
            case "-":
                try {
                    res = Double.parseDouble(firstOp) - Double.parseDouble(secondOp);
                } catch (NumberFormatException e) {
                    model.addAttribute("res", "Error: " + e.getMessage());
                }
                break;
            case "*":
                try {
                    res = Double.parseDouble(firstOp) * Double.parseDouble(secondOp);
                } catch (NumberFormatException e) {
                    model.addAttribute("res","Error: " + e.getMessage());
                }
                break;
            case "/":
                try {
                    if (Double.parseDouble(secondOp) == 0) {
                        model.addAttribute("res", "You can't divide by zero");
                    } else {
                        res = Double.parseDouble(firstOp) / Double.parseDouble(secondOp);
                    }
                } catch (NumberFormatException e) {
                    model.addAttribute("res","Error: " + e.getMessage());
                }
                break;
            default:
                break;
        }

        return res;
    }
}
