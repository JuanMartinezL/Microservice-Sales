package com.microservice.Sales.infrastructure.adapters.Controller;

import com.microservice.Sales.application.UseCases.CreateSaleUseCase;
import com.microservice.Sales.application.UseCases.GetSalesByUserUseCase;
import com.microservice.Sales.application.dto.CreateSaleRequest;
import com.microservice.Sales.application.dto.SaleResponse;
import com.microservice.Sales.domain.model.Sale;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SaleController {

    private final CreateSaleUseCase createSaleUseCase;
    private final GetSalesByUserUseCase getSalesByUserUseCase;

    // Único constructor con todas las dependencias requeridas
    public SaleController(CreateSaleUseCase createSaleUseCase, GetSalesByUserUseCase getSalesByUserUseCase) {
        this.createSaleUseCase = createSaleUseCase;
        this.getSalesByUserUseCase = getSalesByUserUseCase;
    }

    @PostMapping
    public ResponseEntity<Sale> createSale(@RequestBody CreateSaleRequest request) {
        Sale createdSale = createSaleUseCase.execute(request);
        return new ResponseEntity<>(createdSale, HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Sale>> getSalesByUser(@PathVariable Integer userId) {
        List<Sale> sales = getSalesByUserUseCase.execute(userId);
        return ResponseEntity.ok(sales);
    }
    @GetMapping("/{id}/details")
    public SaleResponse getSaleDetails(@PathVariable Integer id) {
        return getSaleDetailUseCase.execute(id);
    }

    private static class getSaleDetailUseCase {

        private static SaleResponse execute(Integer id) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public getSaleDetailUseCase() {
        }
    }
}
