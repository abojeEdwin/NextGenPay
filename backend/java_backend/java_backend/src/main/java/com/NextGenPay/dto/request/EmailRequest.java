package com.NextGenPay.dto.request;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;



@Setter
@Getter
public class EmailRequest {

    @NotNull(message="This field is required")
    private String email;


}
