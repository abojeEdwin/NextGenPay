package com.NextGenPay.data.repository;

import com.NextGenPay.data.model.TransactionsHistory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionsHistoryRepository extends MongoRepository<TransactionsHistory,String> {
}
