package com.NextGenPay.service;

import com.NextGenPay.data.model.SellerAdmin;
import com.NextGenPay.data.model.Wallet;
import com.NextGenPay.data.repository.SellerAdminRepository;
import com.NextGenPay.dto.request.GenerateApiKeyRequest;
import com.NextGenPay.dto.response.GenerateApiKeyResponse;
import com.NextGenPay.exception.AccountNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
@RequiredArgsConstructor
public class GenerateApiKeyServiceImpl implements GenerateApiKeyService {

    private final SellerAdminRepository sellerRepo;
    private final SecureRandom random = new SecureRandom();


    @Override
    public GenerateApiKeyResponse generateApiKey(GenerateApiKeyRequest request) {
        SellerAdmin admin = sellerRepo.findBySellerAdminId(request.getSellerId())
                .orElseThrow(() -> new AccountNotFoundException("Account Not found!!!"));

    }
}
