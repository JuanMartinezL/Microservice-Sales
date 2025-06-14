package com.microservice.Sales.application.dto;

import java.util.List;

public class SaleResponse {
    private Integer id;
    private String userName;
    private String userEmail;
    private List<ProductDetail> products;
    private Float total;
    public static class ProductDetail {
        private String name;
        private String description;
        private Float price;
        private Integer quantity;
        private Float subtotal;

        // Getters y setters
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }

        public Float getPrice() { return price; }
        public void setPrice(Float price) { this.price = price; }

        public Integer getQuantity() { return quantity; }
        public void setQuantity(Integer quantity) { this.quantity = quantity; }

        public Float getSubtotal() { return subtotal; }
        public void setSubtotal(Float subtotal) { this.subtotal = subtotal; }
    }

    // Getters y setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    public List<ProductDetail> getProducts() { return products; }
    public void setProducts(List<ProductDetail> products) { this.products = products; }

    public Float getTotal() { return total; }
    public void setTotal(Float total) { this.total = total; }
}