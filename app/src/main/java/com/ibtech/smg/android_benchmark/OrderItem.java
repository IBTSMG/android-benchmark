package com.ibtech.smg.android_benchmark;

public class OrderItem {
    private Integer id;
    private String  account;
    private String item;
    private Integer quantity;
    private Double price;

    public OrderItem(Integer id, String account, String item, Integer quantity, Double price) {
        super();
        this.id = id;
        this.account = account;
        this.item = item;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return account;
    }

    public Integer getId() {
        return id;
    }

    public String getAccount() {
        return account;
    }

    public String getItem() {
        return item;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }
}
