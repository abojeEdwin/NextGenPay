package com.NextGenPay.data.model;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;


@Setter
@Getter
@Document(collection="Customer Profile")
public class CustomerProfile {

    @Id
    private String id;

    private String customerId;

    private String firstName;

    private String lastName;

    private String address;

    private String userName;

    private LocalDate dateOfBirth;

    private String profileImage;



}
