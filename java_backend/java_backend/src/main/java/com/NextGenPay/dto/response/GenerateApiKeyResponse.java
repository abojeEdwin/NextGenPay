package com.NextGenPay.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenerateApiKeyResponse {
    private String sellerId;
    private String apiKey;
    private String message;
}
