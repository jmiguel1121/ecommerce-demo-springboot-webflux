package com.demo.comercio.electronico.service;

import com.demo.comercio.electronico.dto.PriceListDto;
import com.demo.comercio.electronico.dto.QueryPriceDto;
import com.demo.comercio.electronico.entity.Prices;
import com.demo.comercio.electronico.repository.BrandRepository;
import com.demo.comercio.electronico.repository.PriceListRepository;
import com.demo.comercio.electronico.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class PriceService {

    @Autowired
    private PriceRepository priceRepository;
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private PriceListRepository priceListRpository;

    public Flux<Prices> findAll() {
        return priceRepository.findAll().flatMap(price -> brandRepository.findById(price.getBrandId()).map(brand -> {
            price.setBrand(brand);
            return price;
        }));
    }

    public Flux<QueryPriceDto> findRangeDates(QueryPriceDto queryPriceDto) {
        return priceRepository.findByDateProductBrand(queryPriceDto.getQueryDate(),
                        queryPriceDto.getProductId(), queryPriceDto.getBrandId())
                .flatMap(price -> priceListRpository.findById(price.getPriceListId())
                        .map(lst -> QueryPriceDto.builder().priceList(PriceListDto.from(lst))
                                .queryDate(queryPriceDto.getQueryDate())
                                .startDate(price.getStartDate())
                                .endDate(price.getEndDate())
                                .price(price.getPrice())
                                .brandId(price.getBrandId())
                                .productId(price.getProductId())
                                .startDate(price.getStartDate())
                                .endDate(price.getEndDate())
                                .priceList(PriceListDto.from(lst)).build()));
    }
}
