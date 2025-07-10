package com.NextGenPay.data.model;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Getter
@Setter
@Document(collection = "Customer")
public class Customer extends User{

    @Id
    private String customerId;

    @NotNull(message = "This field is required")
    private String Password;

    @NotNull(message = "This field is required")
    CustomerStatus customerStatus;




}
