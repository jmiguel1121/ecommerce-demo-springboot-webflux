package com.demo.comercio.electronico.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Table;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PRICE_LIST")
public class PriceList {

    @Id
    @Column(name = "PRICE_LIST_ID", nullable = false)
    private Long priceListId;
    @Column(name = "PRICE", nullable = false)
    private Double price;
}
