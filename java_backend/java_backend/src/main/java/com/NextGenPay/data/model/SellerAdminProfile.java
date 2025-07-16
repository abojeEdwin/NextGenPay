package com.NextGenPay.data.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Getter
@Setter
@Document(collection = "SellerAdminProfile")
public class SellerAdminProfile {
    @Id
    private String profileId;
    private String firstName;
    private String lastName;
    private String userName;
    private String businessName;
    BusinessType businessType;
    private LocalDate dateOfBirth;
    private String profileImage;

}
