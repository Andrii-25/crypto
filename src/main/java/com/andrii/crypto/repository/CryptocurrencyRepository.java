package com.andrii.crypto.repository;

import com.andrii.crypto.model.Cryptocurrency;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CryptocurrencyRepository extends MongoRepository<Cryptocurrency, Integer> {
}
