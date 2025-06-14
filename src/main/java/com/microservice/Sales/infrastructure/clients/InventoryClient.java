package com.microservice.Sales.infrastructure.clients;

import com.microservice.Sales.domain.external.Product;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class InventoryClient {
    private final RestTemplate restTemplate = new RestTemplate();

    public Product getProductById(Long productId) {
        return restTemplate.getForObject("http://localhost:8082/inventory/" + productId, Product.class);
    }

    public static class Product {

        public Product() {
        }

        public Integer getStock() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public Float getPrice() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public String getName() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public String getDescription() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }

    
    }
