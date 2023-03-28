package com.bootcamp.bankingproduct.service;

import com.bootcamp.bankingproduct.model.BankingProduct;
import com.bootcamp.bankingproduct.repository.BankingProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BankingProductImpl implements BankingProductService {
    @Autowired
    BankingProductRepository bankingProductRepository;

    @Override
    public Flux<BankingProduct> findAll() {
        return bankingProductRepository.findAll();
    }

    @Override
    public Mono<BankingProduct> findById(String id) {
        return bankingProductRepository.findById(id);
    }

    @Override
    public Mono<BankingProduct> save(BankingProduct bankingProduct) {
        return bankingProductRepository.save(bankingProduct);
    }
}
