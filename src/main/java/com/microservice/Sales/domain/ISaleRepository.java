package com.microservice.Sales.domain;

import com.microservice.Sales.domain.model.Sale;

import java.util.List;
import java.util.Optional;

public interface ISaleRepository {
    public abstract Sale save(Sale  sales);
    
    
        
    List<Sale> consultarTodos();

    public List<Sale> findByUserId(Integer userId);

    public Optional<Sale> findById(Integer saleId);

   
}