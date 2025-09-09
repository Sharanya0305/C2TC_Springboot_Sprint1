package com.tnsif.mall1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mall1")  // explicitly set table name
public class Mall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mallName;
    private String location;
    private int totalShops;
    private double areaSqFt;

    // Default constructor
    public Mall() {}

    // Parameterized constructor (optional)
    public Mall(String mallName, String location, int totalShops, double areaSqFt) {
        this.mallName = mallName;
        this.location = location;
        this.totalShops = totalShops;
        this.areaSqFt = areaSqFt;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMallName() {
        return mallName;
    }

    public void setMallName(String mallName) {
        this.mallName = mallName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTotalShops() {
        return totalShops;
    }

    public void setTotalShops(int totalShops) {
        this.totalShops = totalShops;
    }

    public double getAreaSqFt() {
        return areaSqFt;
    }

    public void setAreaSqFt(double areaSqFt) {
        this.areaSqFt = areaSqFt;
    }

    @Override
    public String toString() {
        return "Mall{" +
                "id=" + id +
                ", mallName='" + mallName + '\'' +
                ", location='" + location + '\'' +
                ", totalShops=" + totalShops +
                ", areaSqFt=" + areaSqFt +
                '}';
    }
}
