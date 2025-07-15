package com.NextGenPay.data.repository;

import com.NextGenPay.data.model.SellerAdmin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface SellerAdminRepository extends MongoRepository<SellerAdmin,String> {
    Optional <SellerAdmin> findBySellerAdminId(String sellerId);
}
