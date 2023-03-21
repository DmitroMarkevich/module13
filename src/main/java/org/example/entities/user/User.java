package org.example.entities.user;

import org.example.entities.user.address.Address;

public class User {
    private int id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;
    public User(int id, String name, String username, String email,
                Address address, String phone, String website, Company company) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.company = company;
    }

    public String getUsername() {
        return username;
    }
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "\n  {" +
                "\n   \"id\": " + id +
                "\n   \"name\": " + name +
                "\n   \"username\": " + username +
                "\n   \"email\": " + email +
                "\n   \"address\": " + "{ " + address +
                "\n   \"phone\": " + phone +
                "\n   \"website\": " + website +
                "\n   \"company\": " + "{ " + company +
                "\n}";
    }
}
