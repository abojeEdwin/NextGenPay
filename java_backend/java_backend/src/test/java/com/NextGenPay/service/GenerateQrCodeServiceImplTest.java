package com.NextGenPay.service;

import com.NextGenPay.data.model.SellerAdmin;
import com.NextGenPay.data.repository.SellerAdminRepository;
import com.NextGenPay.dto.request.GenerateQrCodeRequest;
import com.NextGenPay.dto.response.GenerateQrCodeResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GenerateQrCodeServiceImplTest {
    @Autowired
    private SellerAdminRepository sellerRepo;

    @Autowired
    private GenerateQrCodeServiceImpl qrCodeService;

    @Autowired
    private ObjectMapper objectMapper;

    private String apiKey;
    private String cashierId = "cashier-001";

    @BeforeEach
    void setUp() {
        sellerRepo.deleteAll();

        SellerAdmin admin = new SellerAdmin();
        admin.setSellerAdminId("seller-123");
        apiKey = "test-api-key-xyz";
        admin.setApiKey(apiKey);
        admin.setCashierIds(List.of(cashierId));
        sellerRepo.save(admin);
    }

    @Test
    void generateQr_returnsValidBase64PngContainingCorrectPayload() throws Exception {
        BigDecimal amount = new BigDecimal("2000.00");
        GenerateQrCodeRequest request = new GenerateQrCodeRequest(cashierId, amount);

        GenerateQrCodeResponse response = qrCodeService.generateQrCode(apiKey, request);

        assertThat(response).isNotNull();
        assertThat()
    }

}