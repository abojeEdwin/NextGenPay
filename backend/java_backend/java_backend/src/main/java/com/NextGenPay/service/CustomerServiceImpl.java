package com.NextGenPay.service;

import com.NextGenPay.data.model.Customer;
import com.NextGenPay.data.model.CustomerStatus;
import com.NextGenPay.data.repository.CustomerRepo;
import com.NextGenPay.dto.request.CustomerLoginRequest;
import com.NextGenPay.dto.request.CustomerRegisterRequest;
import com.NextGenPay.dto.response.CustomerLoginResponse;
import com.NextGenPay.dto.response.CustomerRegisterResponse;
import com.NextGenPay.exception.EmailAlreadyExistException;
import com.NextGenPay.exception.InvalidEmailException;
import com.NextGenPay.exception.InvalidPhoneNumberException;
import com.NextGenPay.util.HashPassword;
import com.NextGenPay.util.VerifyEmail;
import com.NextGenPay.util.VerifyPhone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CustomerServiceImpl implements com.NextGenPay.service.CustomerServiceAuth {

    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private VerifyEmail verifyEmail;
    @Autowired
    private VerifyPhone verifyPhone;
    @Autowired
    private HashPassword hashPassword;

    @Override
    public CustomerRegisterResponse registerCustomer(CustomerRegisterRequest registerRequest) {
       if(customerRepo.existsByEmail(registerRequest.getEmail())){
           throw new EmailAlreadyExistException("Email already exists");}
        if(!verifyEmail.isVerifiedEmail(registerRequest.getEmail())){throw new InvalidEmailException("Invalid email, please try again.");}
        if(!verifyPhone.isVerifiedPhoneNumber(registerRequest.getPhoneNumber())){throw new InvalidPhoneNumberException("Invalid phone number");}
        String hashedPassword = HashPassword.hashPassword(registerRequest.getPassword());
       Customer customer = new Customer();
       customer.setEmail(registerRequest.getEmail());
       customer.setCustomerStatus(CustomerStatus.INACTIVE);
       customer.setPassword(hashedPassword);
       customer.setPhoneNumber(registerRequest.getPhoneNumber());
       Customer savedCustomer = customerRepo.save(customer);

       CustomerRegisterResponse registerResponse = new CustomerRegisterResponse(savedCustomer.getCustomerId(),
               savedCustomer.getEmail(),
               savedCustomer.getPhoneNumber(),
               CustomerStatus.INACTIVE);
       return registerResponse;

    }

    @Override
    public CustomerLoginResponse loginCustomer(CustomerLoginRequest loginRequest) {
        CustomerLoginResponse loginResponse = new CustomerLoginResponse();
        Customer foundCustomer = customerRepo.findByEmail(loginRequest.getEmail());
        loginResponse.setMessage("Success");
        return loginResponse;
    }
}
