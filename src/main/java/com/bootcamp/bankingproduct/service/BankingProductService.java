package com.bootcamp.bankingproduct.service;

import com.bootcamp.bankingproduct.model.BankingProduct;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BankingProductService {
    Flux<BankingProduct> findAll();

    Mono<BankingProduct> findById(String id);

    Mono<BankingProduct> save(BankingProduct bankingProduct);
}
