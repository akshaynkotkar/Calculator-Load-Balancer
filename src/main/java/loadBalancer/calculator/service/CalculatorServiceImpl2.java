package loadBalancer.calculator.service;


import org.springframework.stereotype.Service;

@Service("calcService2")
public class CalculatorServiceImpl2 implements CalculatorService {
    @Override
    public double add(double x, double y) {
        System.out.println("Service 2: Executing Function 1 (Addition)");
        return x + y;
    }

    @Override
    public double sub(double x, double y) {
        System.out.println("Service 2: Executing Function 2 (Subtraction)");
        return x - y;
    }

    @Override
    public double mul(double x, double y) {
        System.out.println("Service 2: Executing Function 3 (Multiplication)");
        return x * y;
    }

    @Override
    public double div(double x, double y) {
        System.out.println("Service 2: Executing Function 4 (Division)");
        if (y == 0) throw new IllegalArgumentException("Division by zero");
        return x / y;
    }
}