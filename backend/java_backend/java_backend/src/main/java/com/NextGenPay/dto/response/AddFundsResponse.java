package com.NextGenPay.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddFundsResponse {
    private String transactionId;
    private Instant dateTransferred =  Instant.now();
    private BigDecimal amount;
    private String message;
}
