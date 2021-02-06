package pl.camp.it.delivery.system.model;

import java.util.Set;

public class Shipping {
    private int id;
    private int shippingNumber;
    private DeliveryAddress sender;
    private DeliveryAddress recipient;
    private ShippingStatus status;
    private double weight;
    private int price;
    private Set<ShippingPoint> shippingPoints;

    public Shipping() {
    }

    public Shipping(int id, int shippingNumber, DeliveryAddress sender,
                    DeliveryAddress recipient, ShippingStatus status,
                    double weight, int price, Set<ShippingPoint> shippingPoints) {
        this.id = id;
        this.shippingNumber = shippingNumber;
        this.sender = sender;
        this.recipient = recipient;
        this.status = status;
        this.weight = weight;
        this.price = price;
        this.shippingPoints = shippingPoints;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getShippingNumber() {
        return shippingNumber;
    }

    public void setShippingNumber(int shippingNumber) {
        this.shippingNumber = shippingNumber;
    }

    public DeliveryAddress getSender() {
        return sender;
    }

    public void setSender(DeliveryAddress sender) {
        this.sender = sender;
    }

    public DeliveryAddress getRecipient() {
        return recipient;
    }

    public void setRecipient(DeliveryAddress recipient) {
        this.recipient = recipient;
    }

    public ShippingStatus getStatus() {
        return status;
    }

    public void setStatus(ShippingStatus status) {
        this.status = status;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Set<ShippingPoint> getShippingPoints() {
        return shippingPoints;
    }

    public void setShippingPoints(Set<ShippingPoint> shippingPoints) {
        this.shippingPoints = shippingPoints;
    }
}
