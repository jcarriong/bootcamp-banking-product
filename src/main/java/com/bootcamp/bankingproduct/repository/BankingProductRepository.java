package com.bootcamp.bankingproduct.repository;

import com.bootcamp.bankingproduct.model.BankingProduct;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankingProductRepository extends ReactiveMongoRepository<BankingProduct, String> {
}
