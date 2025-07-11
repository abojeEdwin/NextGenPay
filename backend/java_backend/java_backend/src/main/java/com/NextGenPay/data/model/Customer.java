package com.NextGenPay.data.model;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "Customer")
public class Customer{

    @Id
    private String customerId;

    @NotNull(message = "This field is required")
    private String email;

    @NotNull(message = "This field is required")
    private String password;

    @NotNull(message = "This field is required")
    private String phoneNumber;

    @NotNull(message = "This field is required")
    CustomerStatus customerStatus;

}
