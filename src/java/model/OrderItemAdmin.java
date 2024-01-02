/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Mr.Thai
 */
public class OrderItemAdmin {
    private String image, name;
    private double price, subtotal;
    private int quantity;

    public OrderItemAdmin() {
        
    }
    public OrderItemAdmin(String image, String name, double price, int quantity, double subtotal) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.subtotal = subtotal;
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
