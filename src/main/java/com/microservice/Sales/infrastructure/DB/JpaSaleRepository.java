/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.microservice.Sales.infrastructure.DB;

import com.microservice.Sales.domain.model.Sale;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JpaSaleRepository extends JpaRepository<Sale, Integer> {
    List<Sale> findByUserId(Integer user_id);
}
