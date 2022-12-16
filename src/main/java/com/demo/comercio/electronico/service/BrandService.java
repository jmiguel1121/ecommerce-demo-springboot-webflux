package com.demo.comercio.electronico.service;

import com.demo.comercio.electronico.entity.Brand;
import com.demo.comercio.electronico.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public Flux<Brand> findAll() {
        return brandRepository.findAll();
    }

    public Mono<Brand> findById(Long brandId) {
        return brandRepository.findById(brandId);
    }
}
