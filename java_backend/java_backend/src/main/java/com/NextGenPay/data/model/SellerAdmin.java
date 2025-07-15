package com.NextGenPay.data.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "SellerAdmin")
public class SellerAdmin {
    @Id
    private String sellerAdminId;
    private String cashierId;
    private String apiKey;
}
