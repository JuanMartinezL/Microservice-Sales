package com.microservice.Sales.infrastructure.adapters.Repository;

import com.microservice.Sales.domain.model.Sale;
import com.microservice.Sales.infrastructure.DB.JpaSaleRepository;
import com.microservice.Sales.domain.ISaleRepository;
import java.util.List;
import java.util.Optional;
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

    @Override
    public Optional<Sale> findById(Integer saleId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  

   
}
