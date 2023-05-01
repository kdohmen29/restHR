package com.astontech.resthr.domain;


import lombok.Data;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
public class Vehicle {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String vin;

    private String color;
    private Integer year;

    public Vehicle(String vin, String color, Integer year) {
        this.vin = vin;
        this.color = color;
        this.year = year;
    }

    public Vehicle() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
