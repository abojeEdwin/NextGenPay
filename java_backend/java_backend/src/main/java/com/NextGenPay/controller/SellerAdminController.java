package com.NextGenPay.controller;
import com.NextGenPay.dto.request.CreateCashierRequest;
import com.NextGenPay.dto.request.SellerAdminLoginRequest;
import com.NextGenPay.dto.request.SellerAdminRegisterRequest;
import com.NextGenPay.dto.response.CreateCashierResponse;
import com.NextGenPay.dto.response.SellerAdminLoginResponse;
import com.NextGenPay.dto.response.SellerAdminRegisterResponse;
import com.NextGenPay.service.SellerAdminService;
import com.NextGenPay.service.SellerAdminServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/seller-admin")
@AllArgsConstructor
public class SellerAdminController {

    @Autowired
    SellerAdminServiceImpl service;


    @PostMapping("/register/admin")
    public ResponseEntity<SellerAdminRegisterResponse> registerSellerAdmin(@RequestBody @Valid SellerAdminRegisterRequest request){
        return ResponseEntity.ok(service.registerSellerAdmin(request));
    }

    @PostMapping("/login/admin")
    public ResponseEntity<SellerAdminLoginResponse> loginSellerAdmin(@RequestBody @Valid SellerAdminLoginRequest request){
        return ResponseEntity.ok(service.loginSellerAdmin(request));
    }

    @PostMapping("/create-cashier")
    public ResponseEntity<CreateCashierResponse> createCashier(@RequestBody @Valid CreateCashierRequest request){
        return ResponseEntity.ok(service.createCashier(request));
    }
}
