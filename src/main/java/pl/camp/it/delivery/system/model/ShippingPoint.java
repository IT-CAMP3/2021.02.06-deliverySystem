package pl.camp.it.delivery.system.model;

import java.time.LocalDateTime;

public class ShippingPoint {
    private int id;
    private User user;
    private LocalDateTime dateTime;
    private String city;
    private ShippingStatus newStatus;

    public ShippingPoint() {
    }

    public ShippingPoint(int id, User user, LocalDateTime dateTime, String city, ShippingStatus newStatus) {
        this.id = id;
        this.user = user;
        this.dateTime = dateTime;
        this.city = city;
        this.newStatus = newStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public ShippingStatus getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(ShippingStatus newStatus) {
        this.newStatus = newStatus;
    }
}
