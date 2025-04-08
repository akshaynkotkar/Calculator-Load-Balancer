package loadBalancer.calculator.controller;

import loadBalancer.calculator.config.LoadBalancer;
import loadBalancer.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CalculatorController {

    @Autowired
    private LoadBalancer loadBalancer;

    @GetMapping("/function1")
    public double function1(@RequestParam double x, @RequestParam double y) {
        CalculatorService service = loadBalancer.getNextService();
        return service.function1(x, y);
    }

    @GetMapping("/function2")
    public double function2(@RequestParam double x, @RequestParam double y) {
        CalculatorService service = loadBalancer.getNextService();
        return service.function2(x, y);
    }

    @GetMapping("/function3")
    public double function3(@RequestParam double x, @RequestParam double y) {
        CalculatorService service = loadBalancer.getNextService();
        return service.function3(x, y);
    }

    @GetMapping("/function4")
    public double function4(@RequestParam double x, @RequestParam double y) {
        CalculatorService service = loadBalancer.getNextService();
        return service.function4(x, y);
    }
}