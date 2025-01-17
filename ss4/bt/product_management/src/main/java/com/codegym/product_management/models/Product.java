package com.codegym.product_management.models;

import javax.persistence.*;

@Entity(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", columnDefinition = "LONGTEXT")
    private String name;

    @Column(name = "price", columnDefinition = "DOUBLE")
    private double price;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "produce", columnDefinition = "TEXT")
    private String produce;

    public Product() {
    }

    public Product(int id, String name, double price, String description, String produce) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.produce = produce;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProduce() {
        return produce;
    }

    public void setProduce(String produce) {
        this.produce = produce;
    }
}
