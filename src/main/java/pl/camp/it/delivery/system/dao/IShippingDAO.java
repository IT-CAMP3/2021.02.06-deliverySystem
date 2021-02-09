package pl.camp.it.delivery.system.dao;

import pl.camp.it.delivery.system.model.Shipping;

import java.util.Optional;

public interface IShippingDAO {
    void persist(Shipping shipping);
    Optional<Shipping> getShippingByNumber(int number);
}
