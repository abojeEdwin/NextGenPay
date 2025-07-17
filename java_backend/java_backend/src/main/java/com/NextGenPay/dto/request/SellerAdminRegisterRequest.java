package com.NextGenPay.dto.request;
import com.NextGenPay.data.model.BusinessType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SellerAdminRegisterRequest {

    @NotNull(message="This field is required")
    private String businessName;
    @NotNull(message="This field is required")
    BusinessType businessType;
    @NotNull(message="This field is required")
    private String firstName;
    @NotNull(message="This field is required")
    private String lastName;
    @Email
    private String email;
    @NotNull(message = "This field is required")
    private String password;


}
