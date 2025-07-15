package com.NextGenPay.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddFundsRequest {
    @NotBlank
    private String accountNumber;
    @NotNull @DecimalMin("0.01")
    private BigDecimal amount;
}
