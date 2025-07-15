package com.NextGenPay.controller;

import com.NextGenPay.dto.request.GenerateApiKeyRequest;
import com.NextGenPay.dto.response.GenerateApiKeyResponse;
import com.NextGenPay.service.GenerateApiKeyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sellers")
@RequiredArgsConstructor
public class GenerateApiKeyController {

    private final GenerateApiKeyService service;

    @PostMapping("/{sellerId}/apiKey")
    public ResponseEntity<GenerateApiKeyResponse> generateApiKey(@PathVariable String sellerId,
                                                                 @RequestBody @Valid GenerateApiKeyRequest request) {
        request.setSellerId(sellerId);
        GenerateApiKeyResponse response = service.generateApiKey(request);
        return ResponseEntity.ok(response);
    }
}
