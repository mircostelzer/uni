package gvarni.unitn.esempio12;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public double calculate(double op1, double op2, String operator) {
        double result = 0.0;

        switch (operator) {
            case "+":
                result = op1 + op2;
                break;
            case "-":
                result = op1 - op2;
                break;
            case "*":
                result = op1 * op2;
                break;
            case "/":
                if (op2 != 0) {
                    result = op1 / op2;
                } else {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }

        return result;

    }
}
