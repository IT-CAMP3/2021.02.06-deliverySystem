package pl.camp.it.delivery.system.serives;

import pl.camp.it.delivery.system.model.Shipping;

import java.util.Optional;

public interface IShippingService {
    void persist(Shipping shipping);
    Optional<Shipping> getShippingByNumber(int number);
    void sendShipment(int number, String weight);
    void getShipment(int number, String city);
}
