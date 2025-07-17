package com.NextGenPay.data.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "SellerAdmin")
public class SellerAdmin {

    @Id
    private String sellerAdminId;
    private String email;
    private String password;
    private String businessName;
    BusinessType businessType;
    private String firstName;
    private String lastName;
    private String apiKey;
}
