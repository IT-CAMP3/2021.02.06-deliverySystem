package pl.camp.it.delivery.system.serives.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import pl.camp.it.delivery.system.dao.IShippingDAO;
import pl.camp.it.delivery.system.model.Shipping;
import pl.camp.it.delivery.system.model.ShippingPoint;
import pl.camp.it.delivery.system.model.ShippingStatus;
import pl.camp.it.delivery.system.serives.IPricingService;
import pl.camp.it.delivery.system.serives.IShippingService;
import pl.camp.it.delivery.system.session.SessionObject;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ShippingServiceImpl implements IShippingService {

    @Autowired
    IShippingDAO shippingDAO;

    @Autowired
    IPricingService pricingService;

    @Resource
    SessionObject sessionObject;

    @Override
    public void persist(Shipping shipping) {
        this.shippingDAO.persist(shipping);
    }

    @Override
    public Optional<Shipping> getShippingByNumber(int number) {
        return this.shippingDAO.getShippingByNumber(number);
    }

    @Override
    public void sendShipment(int number, String weight) {
        Optional<Shipping> shipping = this.shippingDAO.getShippingByNumber(number);
        double doubleWeight = Double.parseDouble(weight.replace(",", "."));
        shipping.get().setWeight(doubleWeight);
        shipping.get().setStatus(ShippingStatus.SENT);
        shipping.get().setPrice(this.pricingService.calculatePrice(doubleWeight));

        this.shippingDAO.persist(shipping.get());
    }

    @Override
    public void getShipment(int number, String city) {
        Optional<Shipping> shipping = this.shippingDAO.getShippingByNumber(number);
        shipping.get().setStatus(ShippingStatus.TRANSPORTATION);
        ShippingPoint shippingPoint = new ShippingPoint();
        shippingPoint.setUser(this.sessionObject.getUser());
        shippingPoint.setCity(city);
        shippingPoint.setDateTime(LocalDateTime.now());
        shippingPoint.setNewStatus(ShippingStatus.TRANSPORTATION);

        shipping.get().getShippingPoints().add(shippingPoint);

        this.shippingDAO.persist(shipping.get());
    }
}
