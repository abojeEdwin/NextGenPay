package com.NextGenPay.service;
import com.NextGenPay.dto.request.CustomerLoginRequest;
import com.NextGenPay.dto.request.CustomerRegisterRequest;
import com.NextGenPay.dto.response.CustomerLoginResponse;
import com.NextGenPay.dto.response.CustomerRegisterResponse;



public interface CustomerServiceAuth {
    CustomerRegisterResponse registerCustomer(CustomerRegisterRequest RegisterRequest);
    CustomerLoginResponse loginCustomer(CustomerLoginRequest loginRequest);
}
