package com.microservice.Sales.application.UseCases;

import com.microservice.Sales.application.dto.SaleResponse;
import com.microservice.Sales.application.dto.SaleResponse.ProductDetail;
import com.microservice.Sales.domain.ISaleRepository;
import com.microservice.Sales.domain.model.Sale;
import com.microservice.Sales.domain.model.SaleDetail;
import com.microservice.Sales.infrastructure.clients.UserClient;
import com.microservice.Sales.infrastructure.clients.InventoryClient;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.microservice.Sales.domain.external.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;


@Service
public class GetSaleDetailUseCase {

    private final ISaleRepository saleRepository;
    private final UserClient userClient;
    private final InventoryClient inventoryClient;

    public GetSaleDetailUseCase(ISaleRepository saleRepository, UserClient userClient, InventoryClient inventoryClient) {
        this.saleRepository = saleRepository;
        this.userClient = userClient;
        this.inventoryClient = inventoryClient;
    }

    public SaleResponse execute(Integer saleId) {
        Optional<Sale> optionalSale = saleRepository.findById(saleId);
        if (optionalSale.isEmpty()) {
            throw new IllegalArgumentException("Venta no encontrada");
        }

        Sale sale = optionalSale.get();
        User user = userClient.getUserById(sale.getUserId().longValue());



        if (user == null) {
            throw new IllegalArgumentException("Usuario no encontrado");
        }

        List<ProductDetail> productDetails = sale.getSaleDetails().stream().map(detail -> {
            InventoryClient.Product product = inventoryClient.getProductById(detail.getProductId().longValue());

            ProductDetail pd = new ProductDetail();
            pd.setName(product.getName());
            pd.setDescription(product.getDescription());
            pd.setPrice(detail.getPrice());
            pd.setQuantity(detail.getQuantity());
            pd.setSubtotal(detail.getSubtotal());

            return pd;
        }).collect(Collectors.toList());

        SaleResponse response = new SaleResponse();
        response.setId(sale.getId());
        response.setUserName(user.getName());
        response.setUserEmail(user.getEmail());
        response.setProducts(productDetails);
        response.setTotal(
            sale.getSaleDetails()
                .stream()
                .map(SaleDetail::getSubtotal)
                .reduce(0f, Float::sum)
        );

        return response;
    }
}
