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

    @GetMapping("/add")
    public double add(@RequestParam double x, @RequestParam double y) {
        CalculatorService service = loadBalancer.getNextService();
        return service.add(x, y);
    }

    @GetMapping("/sub")
    public double sub(@RequestParam double x, @RequestParam double y) {
        CalculatorService service = loadBalancer.getNextService();
        return service.sub(x, y);
    }

    @GetMapping("/mul")
    public double mul(@RequestParam double x, @RequestParam double y) {
        CalculatorService service = loadBalancer.getNextService();
        return service.mul(x, y);
    }

    @GetMapping("/div")
    public double div(@RequestParam double x, @RequestParam double y) {
        CalculatorService service = loadBalancer.getNextService();
        return service.div(x, y);
    }
}