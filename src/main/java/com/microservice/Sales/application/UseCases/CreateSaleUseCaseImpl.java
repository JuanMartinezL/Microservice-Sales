package com.microservice.Sales.application.UseCases;

import com.microservice.Sales.application.dto.CreateSaleRequest;
import com.microservice.Sales.domain.model.Sale;
import com.microservice.Sales.domain.ISaleRepository;
import org.springframework.stereotype.Service;
import com.microservice.Sales.infrastructure.clients.UserClient;
import com.microservice.Sales.infrastructure.clients.InventoryClient;



@Service
public class CreateSaleUseCaseImpl extends CreateSaleUseCase {

    private final ISaleRepository saleRepository;

    public CreateSaleUseCaseImpl(
        ISaleRepository saleRepository,
        UserClient userClient,
        InventoryClient inventoryClient
    ) {
        super(saleRepository, userClient, inventoryClient); // Llamada al constructor padre
        this.saleRepository = saleRepository;
    }

    @Override
    public Sale execute(CreateSaleRequest request) {
        Sale sale = new Sale(request.getUserId(), request.toDetails());
        return saleRepository.save(sale);
    }
}
