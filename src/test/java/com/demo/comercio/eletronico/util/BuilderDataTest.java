package com.demo.comercio.eletronico.util;

import com.demo.comercio.electronico.dto.QueryPriceDto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BuilderDataTest {

    public static QueryPriceDto builderQueryPriceDto() {
        String strDate = "2020-12-30 23:59:59";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(strDate, formatter);

        return QueryPriceDto.builder().queryDate(dateTime).productId(35455L).brandId(1L).build();
    }
}
