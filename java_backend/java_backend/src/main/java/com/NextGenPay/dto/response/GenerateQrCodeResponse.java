package com.NextGenPay.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenerateQrCodeResponse {
    private String qrCodeBase64;
    private Instant expiresAt;
}
