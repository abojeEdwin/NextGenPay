package com.NextGenPay.service;
import com.NextGenPay.data.model.SellerAdmin;
import com.NextGenPay.data.repository.SellerAdminRepository;
import com.NextGenPay.dto.request.CreateCashierRequest;
import com.NextGenPay.dto.request.SellerAdminLoginRequest;
import com.NextGenPay.dto.request.SellerAdminRegisterRequest;
import com.NextGenPay.dto.response.CreateCashierResponse;
import com.NextGenPay.dto.response.SellerAdminLoginResponse;
import com.NextGenPay.dto.response.SellerAdminRegisterResponse;
import com.NextGenPay.exception.AdminNotFoundException;
import com.NextGenPay.exception.InvalidLoginCredentials;
import com.NextGenPay.util.HashPassword;
import com.NextGenPay.util.JwtAuth;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class SellerAdminServiceImpl implements SellerAdminService {

    @Autowired
    JwtAuth jwtService;
    @Autowired
    ObjectMapper  objectMapper;
    @Autowired
    HashPassword hashPassword;

    @Autowired
    private SellerAdminRepository sellerAdminRepository;

    @Override
    public SellerAdminRegisterResponse registerSellerAdmin(SellerAdminRegisterRequest request) {
        String hashedPassword = HashPassword.hashPassword(request.getPassword());
        SellerAdmin sellerAdmin = objectMapper.convertValue(request,SellerAdmin.class);
        sellerAdmin.setPassword(hashedPassword);
        SellerAdmin savedSellerAdmin = sellerAdminRepository.save(sellerAdmin);
        String message = "Admin registered successfully";
        return new SellerAdminRegisterResponse(message,savedSellerAdmin.getSellerAdminId());
    }

    @Override
    public SellerAdminLoginResponse loginSellerAdmin(SellerAdminLoginRequest request) {
        SellerAdmin foundAdmin = sellerAdminRepository.findByEmail(request.getEmail());
        if(foundAdmin == null){
            throw new AdminNotFoundException("Seller admin not found");
        }
        if(!HashPassword.verifyPassword(request.getPassword(),foundAdmin.getPassword())){
            throw new InvalidLoginCredentials("Invalid email or password.");
        }
        String token = jwtService.generateToken(foundAdmin.getSellerAdminId());
        SellerAdminLoginResponse loginResponse = new SellerAdminLoginResponse();
        loginResponse.setToken(token);
        loginResponse.setSellerAdminId(foundAdmin.getSellerAdminId());
        loginResponse.setMessage("Success");
        return loginResponse;
    }

    @Override
    public CreateCashierResponse createCashier(CreateCashierRequest request) {
        return null;
    }
}
