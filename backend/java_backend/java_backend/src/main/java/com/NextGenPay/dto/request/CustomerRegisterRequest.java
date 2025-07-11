package com.NextGenPay.dto.request;
import com.NextGenPay.data.model.CustomerStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class CustomerRegisterRequest {

    @NotNull(message="This field is required")
    private String email;

    @NotNull(message="This field is required")
    private String password;

    @NotNull(message="This field is required")
    private String phoneNumber;

    CustomerStatus customerStatus;




}
