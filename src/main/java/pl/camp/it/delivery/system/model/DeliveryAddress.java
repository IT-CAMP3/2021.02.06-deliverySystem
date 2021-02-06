package pl.camp.it.delivery.system.model;

public class DeliveryAddress {
    private int id;
    private String name;
    private String surname;
    private String street;
    private String no;
    private String postCode;
    private String city;

    public DeliveryAddress() {
    }

    public DeliveryAddress(int id, String name, String surname, String street, String no, String postCode, String city) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.street = street;
        this.no = no;
        this.postCode = postCode;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
