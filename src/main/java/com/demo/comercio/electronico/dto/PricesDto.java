package com.demo.comercio.electronico.dto;

import com.demo.comercio.electronico.entity.Brand;
import com.demo.comercio.electronico.entity.Currency;
import com.demo.comercio.electronico.entity.PriceList;
import com.demo.comercio.electronico.entity.Product;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
public class PricesDto {

    private Long pricesId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer priority;
    private Double price;
    private PriceList priceList;
    private Product product;
    private Currency currency;
    private Brand brand;
}
