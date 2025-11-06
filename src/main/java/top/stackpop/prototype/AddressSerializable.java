package top.stackpop.prototype;

import java.io.Serializable;

public class AddressSerializable implements Serializable{

    private static final long serialVersionUID = 1L;

    private String city;

    private String street;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public AddressSerializable(String city, String street) {
        this.city = city;
        this.street = street;
    }

    @Override
    public String toString() {
        return "AddressSerializable [city=" + city + ", street=" + street + "]";
    }

    
    
}
