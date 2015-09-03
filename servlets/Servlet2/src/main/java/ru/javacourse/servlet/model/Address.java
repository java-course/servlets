package ru.javacourse.servlet.model;

/**
 * Created by Georgy Gobozov on 9/3/2015.
 */
public class Address {

    private String city;
    private String street;
    private int zip;

    public Address(String city, String street, int zip) {
        this.city = city;
        this.street = street;
        this.zip = zip;
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

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }
}
