package com.NextGenPay.data.model;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;


@Getter
@Setter
@Document(collection = "Cashier")
public class Cashier {

    @Id
    private String cashierId;
    private String userName;
    private String phoneNumber;
    private String accountNumber;
    private LocalDate dateOfBirth;
    private String sellerAdminId;

}
