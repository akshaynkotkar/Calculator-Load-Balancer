package loadBalancer.calculator.service;

import org.springframework.stereotype.Service;

@Service("calcService1")
public class CalculatorServiceImpl1 implements CalculatorService {
    @Override
    public double add(double x, double y) {
        System.out.println("Service 1: Executing Function 1 (Addition)");
        return x + y;
    }

    @Override
    public double sub(double x, double y) {
        System.out.println("Service 1: Executing Function 2 (Subtraction)");
        return x - y;
    }

    @Override
    public double mul(double x, double y) {
        System.out.println("Service 1: Executing Function 3 (Multiplication)");
        return x * y;
    }

    @Override
    public double div(double x, double y) {
        System.out.println("Service 1: Executing Function 4 (Division)");
        if (y == 0) throw new IllegalArgumentException("Division by zero");
        return x / y;
    }
}