package com.NextGenPay.data.repository;
import com.NextGenPay.data.model.DebitTransactionHistory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DebitTransactionHistoryRepo extends MongoRepository<DebitTransactionHistory,String>{
}
