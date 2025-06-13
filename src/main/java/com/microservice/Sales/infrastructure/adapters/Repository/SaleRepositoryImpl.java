package com.microservice.Sales.infrastructure.adapters.Repository;

import com.microservice.Sales.domain.model.Sale;
import com.microservice.Sales.infrastructure.DB.JpaSaleRepository;
import com.microservice.sales.domain.ISaleRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class SaleRepositoryImpl implements ISaleRepository {

    private final JpaSaleRepository jpaRepository;

    public SaleRepositoryImpl(JpaSaleRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Sale save(Sale sale) {
        return jpaRepository.save(sale);
    }

    public List<Sale> findByUserId(Integer userId) {
        return jpaRepository.findByUserId(userId);
    }

    @Override
    public List<Sale> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

  

   
}
