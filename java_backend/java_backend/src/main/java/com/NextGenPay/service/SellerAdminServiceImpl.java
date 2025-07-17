package com.NextGenPay.service;
import com.NextGenPay.data.model.SellerAdmin;
import com.NextGenPay.data.repository.SellerAdminRepository;
import com.NextGenPay.dto.request.CreateCashierRequest;
import com.NextGenPay.dto.request.SellerAdminLoginRequest;
import com.NextGenPay.dto.request.SellerAdminRegisterRequest;
import com.NextGenPay.dto.response.CreateCashierResponse;
import com.NextGenPay.dto.response.SellerAdminLoginResponse;
import com.NextGenPay.dto.response.SellerAdminRegisterResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class SellerAdminServiceImpl implements SellerAdminService {


    ObjectMapper  objectMapper = new ObjectMapper();

    @Autowired
    private SellerAdminRepository sellerAdminRepository;

    @Override
    public SellerAdminRegisterResponse registerSellerAdmin(SellerAdminRegisterRequest request) {
        SellerAdmin sellerAdmin = objectMapper.convertValue(request,SellerAdmin.class);
        SellerAdmin savedSellerAdmin = sellerAdminRepository.save(sellerAdmin);
        String message = "Admin registered successfully";
        return new SellerAdminRegisterResponse(message,savedSellerAdmin.getSellerAdminId());
    }

    @Override
    public SellerAdminLoginResponse loginSellerAdmin(SellerAdminLoginRequest request) {
        return null;
    }

    @Override
    public CreateCashierResponse createCashier(CreateCashierRequest request) {
        return null;
    }
}
