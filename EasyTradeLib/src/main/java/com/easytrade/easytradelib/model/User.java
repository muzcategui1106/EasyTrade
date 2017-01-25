package com.easytrade.easytradelib.model;

import org.springframework.data.annotation.Id;

/**
 * Created by muzcategui1106 on 1/23/2017.
 */
public class User implements MongoObject {
    @Id
    private String id;
    private String address;
    private String country;
    private String firstName;
    private String lastName;
    private String middleName;
    private String zipCode;

    public User(String address, String country, String firstName, String middleName, String zipCode) {
        this.address = address;
        this.country = country;
        this.firstName = firstName;
        this.middleName = middleName;
        this.zipCode = zipCode;
    }

    public User(){
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
