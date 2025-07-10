package com.NextGenPay.data.model;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "Customer")
public class Customer extends User{


    private String customerId;

    @NotNull(message = "This field is required")
    private String Password;

    @NotNull(message = "This field is required")
    CustomerStatus customerStatus;




}
