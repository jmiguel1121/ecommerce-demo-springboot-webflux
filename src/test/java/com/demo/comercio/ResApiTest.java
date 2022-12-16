package com.demo.comercio;

import com.demo.comercio.electronico.dto.QueryPriceDto;
import com.demo.comercio.electronico.entity.Prices;
import com.demo.comercio.electronico.service.BrandService;
import com.demo.comercio.electronico.service.PriceService;
import com.demo.comercio.electronico.util.PathConstant;
import com.demo.comercio.eletronico.util.BuilderDataTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RunWith(SpringRunner.class)
@WebFluxTest
public class ResApiTest {

    @Autowired
    private WebTestClient webTestClient;
    @Autowired
    private ApplicationContext context;
    @MockBean
    private PriceService priceService;
    @MockBean
    private BrandService brandService;

    @Before
    public void setup() {
        webTestClient = WebTestClient.bindToApplicationContext(context).build();
    }

    @Test
    public void requestAllPricesTest() {
        webTestClient.get().uri(PathConstant.PATH_PRICE)
                .accept(MediaType.APPLICATION_JSON).exchange().expectStatus()
                .isOk().expectBodyList(Prices.class).consumeWith((response) -> {
                    Assert.assertNotNull(response.getResponseBody());
                });

    }

    @Test
    public void findByRangeDatesPricesTest() {
        webTestClient.post().uri(PathConstant.PATH_PRICE + PathConstant.PATH_PRICE_RANGE)
                .body(Mono.just(BuilderDataTest.builderQueryPriceDto()), QueryPriceDto.class)
                .header(CONTENT_TYPE, APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON).exchange().expectStatus()
                .isOk().expectBodyList(Prices.class)
                .consumeWith((response) -> {
                    Assert.assertNotNull(response.getResponseBody());
                });
    }

}
