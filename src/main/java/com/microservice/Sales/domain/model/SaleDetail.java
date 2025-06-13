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

    public void setProductId(Integer productId) {
    this.productId = productId;
}

public void setQuantity(Integer quantity) {
    this.quantity = quantity;
}

public void setPrice(Float price) {
    this.price = price;
}
}
