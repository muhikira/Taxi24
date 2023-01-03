package com.muhikira.taxi24.entity;

import jakarta.persistence.Entity;

import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "driver")
public class Driver {

    // define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driver_id")
    private Long id;
    private String firstName;
    private String lastName;
    private String status;


    @OneToMany(mappedBy = "driver")
    private Set<Rider> riders;

     // define constructors

    public Driver() {
    }

    public Driver(String firstName, String lastName, String status ) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
    }
//define getter and setters

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<Rider> getRiders() {
        return riders;
    }

    public void setRiders(Set<Rider> riders) {
        this.riders = riders;
    }

    // define toString


    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
