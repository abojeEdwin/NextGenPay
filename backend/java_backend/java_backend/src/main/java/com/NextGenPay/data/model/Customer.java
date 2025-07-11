package com.NextGenPay.data.model;
import jakarta.validation.constraints.Email;
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

    private String email;

    private String password;

    private String phoneNumber;

    CustomerStatus customerStatus;

}
