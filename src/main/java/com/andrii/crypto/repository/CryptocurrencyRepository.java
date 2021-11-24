package com.andrii.crypto.repository;

import com.andrii.crypto.model.Cryptocurrency;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CryptocurrencyRepository extends MongoRepository<Cryptocurrency, Integer> {

    List<Cryptocurrency> findByCurr1(@Param("name") String curr1);
    Page<Cryptocurrency> findByCurr1(@Param("name") String curr1, Pageable pageable);
}
