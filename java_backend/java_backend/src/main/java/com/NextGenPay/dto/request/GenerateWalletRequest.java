package com.NextGenPay.dto.request;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GenerateWalletRequest {

    @NotBlank
    private String customerId;

}
