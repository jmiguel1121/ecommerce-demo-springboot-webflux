package com.demo.comercio.electronico.controller;

import com.demo.comercio.electronico.dto.QueryPriceDto;
import com.demo.comercio.electronico.entity.Prices;
import com.demo.comercio.electronico.service.PriceService;
import com.demo.comercio.electronico.util.PathConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import static io.netty.handler.codec.http.HttpHeaders.Values.APPLICATION_JSON;

@RestController
@RequestMapping(PathConstant.PATH_PRICE)
public class PriceController {

    @Autowired
    private PriceService priceService;

    @GetMapping(produces = APPLICATION_JSON)
    public Flux<Prices> getAll() {
        return priceService.findAll();
    }

    @PostMapping(PathConstant.PATH_PRICE_RANGE)
    public Flux<QueryPriceDto> findByRangeDates(@RequestBody QueryPriceDto queryPriceDto) {
        return priceService.findRangeDates(queryPriceDto);
    }
}
