package test.simplecalculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    private final CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }


    @GetMapping("/game")
    public String gamePage() {
        return "game";
    }

    @PostMapping("/result")
    public String calculatePost(@RequestParam("firstOp") double firstOp,
                            @RequestParam("secondOp") double secondOp,
                            @RequestParam("op") String op,
                            Model model) {
        try {
            double res = calculatorService.calculate(firstOp, secondOp, op);
            model.addAttribute("result", res);
        } catch (NumberFormatException | ArithmeticException e) {
            model.addAttribute("error", e.getMessage());
        }

        return "result";
    }

    @GetMapping("/result")
    public String calculateGet(@RequestParam("firstOp") double firstOp,
                            @RequestParam("secondOp") double secondOp,
                            @RequestParam("op") String op,
                            Model model) {
        try {
            double res = calculatorService.calculate(firstOp, secondOp, op);
            model.addAttribute("result", res);
        } catch (NumberFormatException | ArithmeticException e) {
            model.addAttribute("error", e.getMessage());
        }

        return "result";
    }

    @GetMapping("/result/end")
    public String endPage() {
        return "end";
    }
}
