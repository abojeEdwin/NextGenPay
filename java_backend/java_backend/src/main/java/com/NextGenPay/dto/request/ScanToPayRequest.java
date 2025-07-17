package com.NextGenPay.dto.request;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ScanToPayRequest {

    @NotNull(message="This field is required")
    private String cashierId;
    @NotNull(message="This field is required")
    private double amount;
    @NotNull(message="This field is required")
    private String accountNumber;
    @NotNull(message="This field is required")
    private String customerId;
}
