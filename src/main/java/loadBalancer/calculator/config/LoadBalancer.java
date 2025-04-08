package loadBalancer.calculator.config;
import loadBalancer.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class LoadBalancer {
    private final AtomicInteger counter = new AtomicInteger(0);
    private final List<CalculatorService> services;

    @Autowired
    public LoadBalancer(
            @Qualifier("calcService1") CalculatorService calcService1,
            @Qualifier("calcService2") CalculatorService calcService2) {
        this.services = Arrays.asList(calcService1, calcService2);
    }

    public CalculatorService getNextService() {
        int index = counter.getAndIncrement() % services.size();
        return services.get(index);
    }
}