package com.NextGenPay.data.model;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Getter
@Setter
@Document(collection = "BankAccount")
public class BankAccount {

    @Id
    private String accountId;
    private String bankName;
    private String accountNumber;
    private String accountName;

}
