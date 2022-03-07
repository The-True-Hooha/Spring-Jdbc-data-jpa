package com.example.demo.Entity;

import javax.persistence.*;

@Entity (name = "customers") //maps to a table
@Table(name = "customers", uniqueConstraints = {@UniqueConstraint
        (name = "customers_unique", columnNames = {"email", "phoneNumber"})})

public class Customers {

    @Id
    @SequenceGenerator(
            name = "Customers_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_sequence"
    )
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "firstName", nullable = false, columnDefinition = "TEXT")
    private String firstName;

    @Column(name = "lastName", nullable = false, columnDefinition = "TEXT")
    private String lastName;

    @Column(name = "email", nullable = false, columnDefinition = "TEXT")
    private String email;

    @Column(name = "phoneNumber", nullable = false, columnDefinition = "TEXT")
    private String phoneNumber;

    @Column(name = "address", nullable = false, columnDefinition = "TEXT")
    private String address;

    @Column(name = "age", nullable = true)
    private Integer age;

    public Customers() {
    }

    //constructors
    public Customers(
                     String firstName,
                     String lastName,
                     String email,
                     String phoneNumber,
                     String address,
                     Integer age)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.age = age;
    }

    //getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    //to string method
    @Override
    public String toString() {
        return "Customers{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }
}

