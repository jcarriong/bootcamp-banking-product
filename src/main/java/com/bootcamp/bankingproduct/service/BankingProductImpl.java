package com.bootcamp.bankingproduct.service;

import com.bootcamp.bankingproduct.model.BankingProduct;
import com.bootcamp.bankingproduct.repository.BankingProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

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

    @Override
    public Mono<BankingProduct> updateProduct(BankingProduct bankingProduct, String idProduct) {
        return bankingProductRepository.findById(idProduct)
                .flatMap(currentProduct -> {
                    currentProduct.setProductTypeCode(bankingProduct.getProductTypeCode());
                    currentProduct.setProductCategory(bankingProduct.getProductCategory());
                    currentProduct.setProductName(bankingProduct.getProductName());
                    currentProduct.setMaintenance(bankingProduct.getMaintenance());
                    currentProduct.setMovementLimit(bankingProduct.getMovementLimit());
                    currentProduct.setTransactionFee(bankingProduct.getTransactionFee());
                    currentProduct.setUpdateDatetime(LocalDateTime.now());
                    return bankingProductRepository.save(currentProduct);
                });
    }

    @Override
    public Mono<BankingProduct> deleteProduct(String idProduct) {
        return bankingProductRepository.findById(idProduct)
                .flatMap(existingProduct -> bankingProductRepository.delete(existingProduct)
                        .then(Mono.just(existingProduct)));
    }
}
