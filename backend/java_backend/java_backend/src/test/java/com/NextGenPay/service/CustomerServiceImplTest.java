package com.NextGenPay.service;

import com.NextGenPay.data.model.Customer;
import com.NextGenPay.data.repository.CustomerRepo;
import com.NextGenPay.dto.request.CustomerLoginRequest;
import com.NextGenPay.dto.request.CustomerRegisterRequest;
import com.NextGenPay.dto.response.CustomerLoginResponse;
import com.NextGenPay.exception.EmailAlreadyExistException;
import com.NextGenPay.exception.InvalidEmailException;
import com.NextGenPay.exception.InvalidPhoneNumberException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CustomerServiceImplTest {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private CustomerServiceImpl customerService;

    @BeforeEach
    void beforeEach(){
        customerRepo.deleteAll();
    }
    @AfterEach
    void afterEach(){
        customerRepo.deleteAll();
    }


    @Test
    public void testCustomerCanRegister() {
        CustomerRegisterRequest request = new CustomerRegisterRequest();
        request.setEmail("Choko@gmail.com");
        request.setPhoneNumber("09096041561");
        request.setPassword("0000");
        customerService.registerCustomer(request);
        assertEquals(1,customerRepo.count());
   }

   @Test
   public void testCustomerCanLogin() {
        CustomerLoginRequest request = new CustomerLoginRequest();
        request.setEmail("Choko@gmail.com");
        request.setPassword("0000");
        CustomerLoginResponse response = customerService.loginCustomer(request);
        assertEquals("Success",response.getMessage());
   }

   @Test
   public void testCustomerRegisterWithDuplicateEmail() {
       CustomerRegisterRequest request = new CustomerRegisterRequest();
       request.setEmail("sam@gmail.com");
       request.setPassword("090998800188");
       request.setPassword("0000");
       customerService.registerCustomer(request);
       assertEquals(1,customerRepo.count());

       CustomerRegisterRequest request1 = new CustomerRegisterRequest();
       request1.setEmail("sam@gmail.com");
       request1.setPhoneNumber("09056424235");
       request1.setPassword("0000");
       assertThrows(EmailAlreadyExistException.class,()->customerService.registerCustomer(request1));
    }

    @Test
    public void testUserRegisterWithInvalidEmail() {
        CustomerRegisterRequest request = new CustomerRegisterRequest();
        request.setEmail("sam@gmail");
        request.setPassword("090998800188");
        request.setPassword("0000");
        assertThrows(InvalidEmailException.class,()->customerService.registerCustomer(request));
    }

    @Test
    public void testCustomerCanRegisterWithInvalidPhoneNumber() {
        CustomerRegisterRequest request = new CustomerRegisterRequest();
        request.setEmail("sam@gmail.com");
        request.setPhoneNumber(" ");
        request.setPassword("0000");
        assertThrows(InvalidPhoneNumberException.class,()-> customerService.registerCustomer(request));
    }







}