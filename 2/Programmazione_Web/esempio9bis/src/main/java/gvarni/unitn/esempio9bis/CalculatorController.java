package gvarni.unitn.esempio9bis;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class CalculatorController {
    @PostMapping("/greet_data")
    public String welcome() {
        return "greet_data";
    }

    @PostMapping("/compute")
    public String compute(@RequestParam("operand1") double op1,
                            @RequestParam("operand2") double op2,
                            @RequestParam("operator") String operator,
                            Model model) {

        double res = 0;
        String operation = "";


        switch (operator) {
            case "+":
                res = op1 + op2;
                operation = "Addition";
                break;
            case "-":
                res = op1 - op2;
                operation = "Subtraction";
                break;
            case "*":
                res = op1 * op2;
                operation = "Multiplication";
                break;
            case "/":
                if (op2 != 0) {
                    res = op1 / op2;
                    operation = "Division";
                } else {
                    model.addAttribute("error", "Cannot divide by zero!");
                    return "results";
                }
                break;
            default:
                model.addAttribute("error", "Invalid operator");
                return "results";
        }

        model.addAttribute("result", res);
        model.addAttribute("operation", operation);
        return "results";
    }

    @PostMapping("/another")
    public String another() {
        return "greet_data";
    }

   @PostMapping("/end")
    public String end() {
      return "end";
    }

}
