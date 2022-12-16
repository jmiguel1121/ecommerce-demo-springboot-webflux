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
@Table(name = "CURRENCY")
public class Currency {

    @Id
    @Column(name = "CURRENCY_ID", nullable = false)
    private Integer currencyId;
    @Column(name = "ACRONYM ", nullable = false)
    private String acronym;
    @Column(name = "DESCRIPTION ", nullable = false)
    private String description;
}
