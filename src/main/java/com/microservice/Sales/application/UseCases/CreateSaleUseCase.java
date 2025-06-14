package com.microservice.Sales.application.UseCases;

import com.microservice.Sales.application.dto.CreateSaleRequest;
import com.microservice.Sales.domain.external.Product;
import com.microservice.Sales.domain.model.Sale;
import com.microservice.Sales.domain.model.SaleDetail;
import com.microservice.Sales.domain.ISaleRepository;
import com.microservice.Sales.domain.external.User;
import com.microservice.Sales.infrastructure.clients.UserClient;
import com.microservice.Sales.infrastructure.clients.InventoryClient;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

@Service
public class CreateSaleUseCase {

    private final ISaleRepository saleRepository;
    final UserClient userClient;
    final InventoryClient inventoryClient;

    public CreateSaleUseCase(ISaleRepository saleRepository, UserClient userClient, InventoryClient inventoryClient) {
        this.saleRepository = saleRepository;
        this.userClient = userClient;
        this.inventoryClient = inventoryClient;
    }

    public Sale execute(CreateSaleRequest request) {
        // Validar usuario
        User user = userClient.getUserById(request.getUserId().longValue());
        if (user == null) {
            throw new IllegalArgumentException("Usuario no encontrado");
        }

        List<SaleDetail> details = request.toDetails();
        float total = 0f;

        for (SaleDetail detail : details) {
            InventoryClient.Product product = inventoryClient.getProductById(detail.getProductId().longValue());


            if (product == null || product.getStock() < detail.getQuantity()) {
                throw new IllegalArgumentException("Producto inválido o stock insuficiente para ID: " + detail.getProductId());
            }

            detail.setPrice(product.getPrice());
            detail.setSubtotal(product.getPrice() * detail.getQuantity());
            total += detail.getSubtotal();
        }

        Sale sale = new Sale(request.getUserId(), details);
        sale.setTotal(total);

        return saleRepository.save(sale);
    }
}
