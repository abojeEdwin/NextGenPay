package com.NextGenPay.data.repository;

import com.NextGenPay.data.model.Cashier;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CashierRepo extends MongoRepository<Cashier, String> {

}
