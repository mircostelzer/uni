package gvarni.unitn.esempio13;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public double calculate(double operand1, double operand2, String operator) {
        double result = 0.0;

        switch (operator) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                if (operand2 != 0) {
                    result = operand1 / operand2;
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
