/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.microservice.Sales.application.dto;

import java.util.List;


public class SaleResponse {
    private Integer id;
    private Integer userId;
    private Float total;
    private List<SaleDetailResponse> details;
    // getters, setters, constructor

    private static class SaleDetailResponse {

        public SaleDetailResponse() {
        }
    }
}
