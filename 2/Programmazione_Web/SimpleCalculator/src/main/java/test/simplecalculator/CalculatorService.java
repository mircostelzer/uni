package test.simplecalculator;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class CalculatorService {

    double calculate(double firstOp, double secondOp, String op) throws NumberFormatException, ArithmeticException {
        double res = 0;
        switch (op) {
            case "+":
                res = firstOp + secondOp;
                break;
            case "-":
                    res = firstOp - secondOp;
                break;
            case "*":
                    res = firstOp * secondOp;
                break;
            case "/":
                    if (secondOp == 0.0) {
                        throw new ArithmeticException("You can't divide by zero");
                    } else {
                        res = firstOp / secondOp;
                    }
                break;
            default:
                break;
        }

        return res;
    }
}
