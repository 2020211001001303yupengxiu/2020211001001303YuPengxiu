package com.model;

import java.io.InputStream;

public class Product {
    private int productId;
    private String productName;
    private String ProductDescrption;
    private InputStream picture;
    private Double price;
    private int categoryId;

    public Product() {
    }

    public Product(int productId, String productName, String productDescrption, InputStream picture, Double price, int categoryId) {
        this.productId = productId;
        this.productName = productName;
        ProductDescrption = productDescrption;
        this.picture = picture;
        this.price = price;
        this.categoryId = categoryId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescrption() {
        return ProductDescrption;
    }

    public void setProductDescrption(String productDescrption) {
        ProductDescrption = productDescrption;
    }

    public InputStream getPicture() {
        return picture;
    }

    public void setPicture(InputStream picture) {
        this.picture = picture;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", ProductDescrption='" + ProductDescrption + '\'' +
                ", picture=" + picture +
                ", price=" + price +
                ", categoryId=" + categoryId +
                '}';
    }
}
