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
@Table(name = "PRODUCT")
public class Product {

    @Id
    @Column(name = "PRODUCT_ID", nullable = false)
    private Long productId;
    @Column(name = "NAME", nullable = false)
    private String name;
}
