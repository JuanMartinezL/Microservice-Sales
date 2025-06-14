package com.microservice.Sales.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GenerationType;


@Entity
public class SaleDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer productId;
    private Integer quantity;
    private Float price;

    @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;

    public Float getSubtotal() {
        return quantity * price;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    // Getters y setters...

   public Integer getProductId() {
    return productId;
}

public Integer getQuantity() {
    return quantity;
}

public Float getPrice() {
    return price;
}

public void setSubtotal(float subtotal) {
    
}

    public void setPrice(Float price) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setProductId(Long productId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setQuantity(Integer quantity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
