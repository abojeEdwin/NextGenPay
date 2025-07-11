package com.NextGenPay.data.model;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;


@Setter
@Getter
@Document(collection="UserProfile")
public class CustomerProfile {

    @Id
    private String Id;

    @NotNull(message = "This field is required")
    private String firstName;

    @NotNull(message = "This field is required")
    private String lastName;

    @NotNull(message ="This field is required")
    private String address;

    @NotNull(message = "This field is required")
    private LocalDate dateOfBirth;

}
