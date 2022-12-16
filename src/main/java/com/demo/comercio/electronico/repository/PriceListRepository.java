package com.demo.comercio.electronico.repository;

import com.demo.comercio.electronico.entity.PriceList;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceListRepository extends ReactiveCrudRepository<PriceList, Long> {
}
