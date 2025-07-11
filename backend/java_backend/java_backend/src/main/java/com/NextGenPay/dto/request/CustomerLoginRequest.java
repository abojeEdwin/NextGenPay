package com.NextGenPay.dto.request;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerLoginRequest {

    @NotNull(message = "This field is required")
    private String email;

    @NotNull(message="This field is required")
    private String password;

    @NotNull(message="This field is required")
    private String otp;

}
