package com.microservice.Sales.application.dto;

import java.util.List;
import java.util.stream.Collectors;
import com.microservice.Sales.domain.model.SaleDetail;


public class CreateSaleRequest {
    private Integer userId;
    private List<Item> items;

    public Integer getUserId() {
        return userId;
    }

    public List<Item> getItems() {
        return items;
    }

    public static class Item {
        private Integer productId;
        private Integer quantity;
        private Float price;

        // Getters y setters
        public Integer getProductId() {
    return productId;
}

public Integer getQuantity() {
    return quantity;
}

public Float getPrice() {
    return price;
}

    }

    public List<SaleDetail> toDetails() {
        return items.stream().map(item -> {
            SaleDetail detail = new SaleDetail();
            detail.setProductId(item.getProductId());
            detail.setQuantity(item.getQuantity());
            detail.setPrice(item.getPrice());
            return detail;
        }).collect(Collectors.toList());
    }
}
