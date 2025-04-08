package loadBalancer.calculator.service;


import org.springframework.stereotype.Service;

@Service("calcService2")
public class CalculatorServiceImpl2 implements CalculatorService {
    @Override
    public double function1(double x, double y) {
        System.out.println("Service 2: Executing Function 1 (Addition)");
        return x + y;
    }

    @Override
    public double function2(double x, double y) {
        System.out.println("Service 2: Executing Function 2 (Subtraction)");
        return x - y;
    }

    @Override
    public double function3(double x, double y) {
        System.out.println("Service 2: Executing Function 3 (Multiplication)");
        return x * y;
    }

    @Override
    public double function4(double x, double y) {
        System.out.println("Service 2: Executing Function 4 (Division)");
        if (y == 0) throw new IllegalArgumentException("Division by zero");
        return x / y;
    }
}