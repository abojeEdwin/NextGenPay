package com.NextGenPay.data.repository;
import com.NextGenPay.data.model.Cashier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashierRepo extends MongoRepository<Cashier, String> {

    Cashier findByCashierId(String cashierId);
}
