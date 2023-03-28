package com.bootcamp.bankingproduct.controller;

import com.bootcamp.bankingproduct.model.BankingProduct;
import com.bootcamp.bankingproduct.service.BankingProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/v1")
@Slf4j
public class BankingProductController {

    @Autowired
    private BankingProductService bankingProductService;

    @GetMapping("/findAll")
    public Flux<BankingProduct> findAll() {
        log.info("All banking products were consulted");
        return bankingProductService.findAll()
                .doOnNext(bankingProduct -> bankingProduct.toString());
    }

    @GetMapping("/findById/{id}")
    public Mono<BankingProduct> findById(@PathVariable("id") String id) {
        log.info("Banking product consulted by id " + id);
        return bankingProductService.findById(id);

    }

    @PostMapping("/save")
    public Mono<ResponseEntity<BankingProduct>> save(@RequestBody BankingProduct bankingProduct) {
        log.info("A bank customer was created");
        bankingProduct.setCreationDatetime(LocalDateTime.now());
        return bankingProductService.save(bankingProduct)
                .map(bc -> new ResponseEntity<>(bc, HttpStatus.CREATED))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.CONFLICT));
    }
}
