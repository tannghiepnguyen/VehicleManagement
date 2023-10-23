/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Entity;

import java.time.LocalDate;

/**
 *
 * @author tanng
 */
public class Vehicle {
    private String ID;
    private String name;
    private String color;
    private int price;
    private String brand;
    private String type;
    private LocalDate productYear;

    public Vehicle() {
    }

    public Vehicle(String ID, String name, String color, int price, String brand, String type, LocalDate productYear) {
        this.ID = ID;
        this.name = name;
        this.color = color;
        this.price = price;
        this.brand = brand;
        this.type = type;
        this.productYear = productYear;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getProductYear() {
        return productYear;
    }

    public void setProductYear(LocalDate productYear) {
        this.productYear = productYear;
    }

    @Override
    public String toString() {
        String result = String.format("ID: %s\tname: %s\tcolor: %s\tprice: $%d\tbrand: %s\ttype: %s\tproduct year: %s.", ID, name, color, price, brand, type, productYear.toString());
        return result;
        
    }
    
    
}
