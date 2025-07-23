package com.NextGenPay.data.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Payload {
    public String cashierId;
    public double amount;
    public String accountNumber;
    public String timeStamp;
}
