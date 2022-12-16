package com.demo.comercio.electronico.repository;

import com.demo.comercio.electronico.entity.Prices;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

@Repository
public interface PriceRepository extends ReactiveCrudRepository<Prices, Long> {
    @Query("SELECT p.* FROM Prices p WHERE p.PRODUCT_ID =:productId AND p.BRAND_ID =:brandId " +
            "AND DATEDIFF(DAY,p.START_DATE,:queryDate) >=0 AND DATEDIFF(DAY,:queryDate,p.END_DATE) >=0")
    Flux<Prices> findByDateProductBrand(LocalDateTime queryDate, Long productId, Long brandId);
}
