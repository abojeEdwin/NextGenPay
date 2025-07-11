package com.NextGenPay.data.repository;
import com.NextGenPay.data.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends MongoRepository<Customer,String> {

    boolean existsByEmail(String email);
    Customer findByEmail(String email);
    boolean existsByPhoneNumber(String phoneNumber);

}
