package com.NextGenPay.dto.response;
import com.NextGenPay.data.model.CustomerStatus;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRegisterResponse {


    @NotNull(message = "This field is required")
    private String customerId;

    @NotNull(message="This field is required")
    private String email;

    @NotNull(message="This field is required")
    private String phoneNumber;

    CustomerStatus customerStatus;

}
