package com.NextGenPay.data.repository;
import com.NextGenPay.data.model.Customer;
import com.NextGenPay.data.model.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;



@Repository
public interface CustomerRepo extends MongoRepository<Customer,String> {

}
