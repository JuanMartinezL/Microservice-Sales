
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
