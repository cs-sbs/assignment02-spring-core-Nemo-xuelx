package org.example.model;

public class Order {
    private Long id;
    private String customerName;
    private String product;
    private double amount;

    // 构造方法
    public Order() {}

    public Order(Long id, String customerName, String product, double amount) {
        this.id = id;
        this.customerName = customerName;
        this.product = product;
        this.amount = amount;
    }

    // 添加getter和setter方法
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", product='" + product + '\'' +
                ", amount=" + amount +
                '}';
    }
}