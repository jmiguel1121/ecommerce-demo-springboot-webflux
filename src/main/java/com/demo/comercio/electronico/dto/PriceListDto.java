package com.demo.comercio.electronico.dto;

import com.demo.comercio.electronico.entity.PriceList;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PriceListDto {

    private Long priceListId;
    private Double price;

    public static PriceListDto from(PriceList entity) {
        return PriceListDto.builder().price(entity.getPrice())
                .priceListId(entity.getPriceListId()).build();
    }
}
