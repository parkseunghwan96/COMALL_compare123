package com.jbnu.comall.model;


import java.util.List;

public class User {
    private String id;
    private String pw;
    private String name;
    private List<Product> cart;

    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }

    public String getName() {
        return name;
    }

    public List<Product> getCart() {
        return cart;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCart(List<Product> cart) {
        this.cart = cart;
    }
}
