package com.microservice.Sales.domain.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Timestamp date;
    private Float total;
    private Integer userId;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    private List<SaleDetail> saleDetails;

    public Sale() {
        this.date = new Timestamp(System.currentTimeMillis());
    }

    public Sale(Integer userId, List<SaleDetail> saleDetails) {
        this.userId = userId;
        this.saleDetails = saleDetails;
        this.date = new Timestamp(System.currentTimeMillis());
        this.total = saleDetails.stream()
            .map(SaleDetail::getSubtotal)
            .reduce(0f, Float::sum);

        saleDetails.forEach(detail -> detail.setSale(this));
    }

    // Getters y setters 
    public Integer getId() {
        
        return id;
    }

    public Timestamp getDate() {
        return date;
    }

    public Integer getUserId() {
        return userId;
    }

    public List<SaleDetail> getSaleDetails() {
        return saleDetails;
    }
}
