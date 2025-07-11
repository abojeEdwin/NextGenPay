package com.NextGenPay.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenerateWalletResponse {
    private BigDecimal balance;
    private String accountNumber;
    private String message;
}
