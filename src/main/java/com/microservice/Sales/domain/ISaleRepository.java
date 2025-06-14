package com.microservice.Sales.domain;

import com.microservice.Sales.domain.model.Sale;

import java.util.List;

public interface ISaleRepository {
    public abstract Sale save(Sale  sales);
    
    
        
    List<Sale> consultarTodos();

    public List<Sale> findByUserId(Integer userId);

   
}