package com.demo.comercio.electronico.controller;

import com.demo.comercio.electronico.entity.Brand;
import com.demo.comercio.electronico.service.BrandService;
import com.demo.comercio.electronico.util.PathConstant;
import io.swagger.annotations.SwaggerDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static io.netty.handler.codec.http.HttpHeaders.Values.APPLICATION_JSON;

@RestController
@RequestMapping(PathConstant.PATH_BRAND)
@SwaggerDefinition(basePath = "/api")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping(produces = APPLICATION_JSON)
    public Flux<Brand> getAll() {
        return brandService.findAll();
    }

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON)
    public Mono<Brand> getById(@PathVariable("id") Long brandId) {
        return brandService.findById(brandId);
    }
}
