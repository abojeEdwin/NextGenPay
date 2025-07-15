package com.NextGenPay.data.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;


@Document(collection = "TransactionHistory")
public class TransactionHistory {

    @Id
    private String transactionId;
    private String accountNumber;
    private BigDecimal amount;
    private LocalDate dateTransferred;
}
