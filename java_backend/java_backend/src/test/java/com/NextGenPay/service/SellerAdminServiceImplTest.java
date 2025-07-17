package com.NextGenPay.service;
import com.NextGenPay.data.model.BusinessType;
import com.NextGenPay.data.model.SellerAdmin;
import com.NextGenPay.data.repository.SellerAdminRepository;
import com.NextGenPay.dto.request.SellerAdminLoginRequest;
import com.NextGenPay.dto.request.SellerAdminRegisterRequest;
import com.NextGenPay.dto.response.SellerAdminLoginResponse;
import com.NextGenPay.dto.response.SellerAdminRegisterResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class SellerAdminServiceImplTest {

    @Autowired
    private SellerAdminServiceImpl sellerAdminService;

    @Autowired
    private SellerAdminRepository sellerRepo;

//    @BeforeEach
//    void setUp() {
//        sellerRepo.deleteAll();
//    }
//
//    @AfterEach
//    void tearDown() {
//        sellerRepo.deleteAll();
//    }

    @Test
    public void testSellerAdminCanRegister() {

        SellerAdminRegisterRequest request = new SellerAdminRegisterRequest();
        request.setBusinessName("main steward");
        request.setBusinessType(BusinessType.REGISTERED);
        request.setFirstName("Aboje");
        request.setLastName("Edwin");
        request.setPassword("password");
        request.setEmail("abojeedwin@gmail.com");
        SellerAdminRegisterResponse response = sellerAdminService.registerSellerAdmin(request);
        assertEquals(1,sellerRepo.count());
        assertEquals(response.getMessage(),"Admin registered successfully");

    }

    @Test
    public void testSellerAdminCanLogin() {

        SellerAdminLoginRequest request = new SellerAdminLoginRequest();
        request.setEmail("abojeedwin@gmail.com");
        request.setPassword("password");
        SellerAdminLoginResponse response = sellerAdminService.loginSellerAdmin(request);
        assert(response.getMessage().equals("Success"));
    }
}