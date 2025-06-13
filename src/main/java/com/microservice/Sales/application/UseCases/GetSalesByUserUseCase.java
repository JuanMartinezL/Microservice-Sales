package com.microservice.Sales.application.UseCases;

import com.microservice.Sales.domain.model.Sale;
import com.microservice.sales.domain.ISaleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetSalesByUserUseCase {

    private final ISaleRepository saleRepository;

    public GetSalesByUserUseCase(ISaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public List<Sale> execute(Integer userId) {
        return saleRepository.findByUserId(userId);
    }
}
