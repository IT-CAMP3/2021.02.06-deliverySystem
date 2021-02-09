package pl.camp.it.delivery.system.serives.impl;

import org.springframework.stereotype.Service;
import pl.camp.it.delivery.system.serives.IPricingService;

@Service
public class PricingServiceImpl implements IPricingService {
    @Override
    public int calculatePrice(double weight) {
        if(weight <= 1.00) {
            return 10;
        } else if(weight > 1.00 && weight<= 3.00 ) {
            return 20;
        } else if(weight > 3.00 && weight <= 6.00) {
            return 30;
        } else {
            return 50;
        }
    }
}
