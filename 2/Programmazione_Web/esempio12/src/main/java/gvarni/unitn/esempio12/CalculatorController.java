package gvarni.unitn.esempio12;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class CalculatorController {
    private final CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }



    @PostMapping("/greet_data")
    public String welcome() {
        return "greet_data";
    }

    @PostMapping("/compute")
    public String compute(@RequestParam("operand1") double operand1,
                            @RequestParam("operand2") double operand2,
                            @RequestParam("operator") String operator,
                            Model model) {

        double res = 0;

        try{
            res= calculatorService.calculate(operand1, operand2, operator);
        }
        catch (ArithmeticException a){
            model.addAttribute("error", a.getMessage());
            return "results";
        }
        catch (IllegalAccessError e){
            model.addAttribute("error", e.getMessage());
            return "results";
        }

        model.addAttribute("result", res);
        model.addAttribute("operation", "Computation done!");
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
