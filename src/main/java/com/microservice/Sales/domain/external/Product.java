package com.microservice.Sales.domain.external;

public class Product {
    private Long id_producto;
    private String name_product;
    private String description;
    private Float price;
    private Integer stock;

    // Getters y setters
    
    
    // Getters
    public Long getId_producto() {
        return id_producto;
    }
    public void setId_producto(Long id_producto) {
        this.id_producto = id_producto;
    }

    public String getName_product() {
        return name_product;
    }
    
    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public String getDescription() {
        return description;
    }
     public void setDescription(String description) {
        this.description = description;
    }


    public Float getPrice() {
        return price;
    }
     public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }
    public void setStock(Integer stock) {
        this.stock = stock;
    }
    
    
}
