package org.example.entities.user.address;

public class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

    public Address(String street, String suite, String city, String zipcode, Geo geo) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.geo = geo;
    }

    @Override
    public String toString() {
        return  "\n     \"street\": " + street +
                "\n     \"suite\": " + suite +
                "\n     \"city\": " + city +
                "\n     \"zipcode\": " + zipcode +
                "\n     \"geo\": " + geo +
                "\n   }";
    }
}
