package com.demo.comercio.electronico.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
public class QueryPriceDto {

    private LocalDateTime queryDate;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long productId;
    private Long brandId;
    private Double price;
    private PriceListDto priceList;
}
