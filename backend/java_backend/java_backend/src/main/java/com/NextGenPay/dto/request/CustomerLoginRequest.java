package com.NextGenPay.dto.request;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerLoginRequest {

    @NotNull(message = "This field is required")
    @Email(message = "This field is required")
    private String email;

    @NotNull(message="This field is required")
    private String password;


}
