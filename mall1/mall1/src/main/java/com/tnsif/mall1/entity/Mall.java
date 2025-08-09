package com.tnsif.mall1.entity; // Changed package name

import jakarta.persistence.*;

@Entity
@Table(name = "malls") // Table name remains 'malls'
public class Mall { // Class name remains 'Mall'

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mall_name")
    private String mallName;

    @Column(name = "location")
    private String location;

    @Column(name = "total_shops")
    private int totalShops;

    @Column(name = "area_sq_ft")
    private double areaSqFt;

    // Constructors
    public Mall() {}

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
        return "Mall{" + // Class name remains 'Mall' in toString
               "id=" + id +
               ", mallName='" + mallName + '\'' +
               ", location='" + location + '\'' +
               ", totalShops=" + totalShops +
               ", areaSqFt=" + areaSqFt +
               '}';
    }
}
