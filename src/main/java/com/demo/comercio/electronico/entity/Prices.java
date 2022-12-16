package com.demo.comercio.electronico.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;


@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PRICES")
public class Prices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRICES_ID", nullable = false)
    private Long pricesId;
    @Column(name = "START_DATE", nullable = false)
    private LocalDateTime startDate;
    @Column(name = "END_DATE", nullable = false)
    private LocalDateTime endDate;
    @Column(name = "PRIORITY", nullable = false)
    private Integer priority;
    @Column(name = "PRICE", nullable = false)//price
    private Double price;
    @Column(name = "PRICE_LIST_ID", nullable = false)
    private Long priceListId;
    @Column(name = "PRODUCT_ID", nullable = false)
    private Long productId;
    @Column(name = "CURRENCY_ID", nullable = false)
    private Integer currencyId;
    @Column(name = "BRAND_ID", nullable = false)
    private Long brandId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRICE_LIST_ID", nullable = false, referencedColumnName = "priceListId")
    private PriceList priceList;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID", nullable = false, referencedColumnName = "productId")
    private Product product;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CURRENCY_ID", nullable = false, referencedColumnName = "currencyId")
    private Currency currency;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BRAND_ID", referencedColumnName = "brandId")
    private Brand brand;
}
