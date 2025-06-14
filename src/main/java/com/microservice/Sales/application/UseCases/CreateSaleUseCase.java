package com.microservice.Sales.application.UseCases;

import com.microservice.Sales.application.dto.CreateSaleRequest;
import com.microservice.Sales.domain.model.Sale;
import com.microservice.Sales.domain.ISaleRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateSaleUseCase { 

    private final ISaleRepository saleRepository;

    public CreateSaleUseCase(ISaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public Sale execute(CreateSaleRequest request) {
        Sale sale = new Sale(request.getUserId(), request.toDetails());
        return saleRepository.save(sale);
    }
}
