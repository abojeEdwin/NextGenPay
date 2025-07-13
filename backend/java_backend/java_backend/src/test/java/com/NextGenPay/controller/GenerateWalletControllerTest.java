package com.NextGenPay.controller;
import com.NextGenPay.dto.request.GenerateWalletRequest;
import com.NextGenPay.dto.response.GenerateWalletResponse;
import com.NextGenPay.service.GenerateWalletServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebMvcTest(GenerateWalletControllerTest.class)
class GenerateWalletControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GenerateWalletServiceImpl service;

    @Autowired
    private ObjectMapper objectMapper;

    private GenerateWalletRequest request;
    private GenerateWalletResponse response;

    @BeforeEach
    void setUp() {
        request = new GenerateWalletRequest("12345678");
        response = new GenerateWalletResponse(
                BigDecimal.ZERO,
                "1234567891",
                "Wallet created successfully"
        );
    }

    @Test
    void postGenerateWallet_returns200_andResponseBody() throws Exception {
        when(service.generateWallet(any(GenerateWalletRequest.class))).thenReturn(response);
    }
}