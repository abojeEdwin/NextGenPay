package com.NextGenPay.data.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.security.SecureRandom;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "accountNumber")
public class AccountNumber {
    @Id
    private String id;
    private String customerId;
    private String accountNumber;

    private static final SecureRandom random = new SecureRandom();

    public static AccountNumber generateAccountNumber(String customerId) {
        StringBuilder sb = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
            sb.append(random.nextInt(10));
        }
        return new AccountNumber(
                null,
                customerId,
                sb.toString()
        );
    }
}
