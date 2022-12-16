package com.demo.comercio.electronico.repository;

import com.demo.comercio.electronico.entity.Brand;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends ReactiveCrudRepository<Brand, Long> {
}
