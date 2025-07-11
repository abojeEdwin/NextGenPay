package com.NextGenPay.util;
import org.springframework.stereotype.Component;
import java.util.regex.Pattern;

@Component
public class VerifyPhone {

    private static String PhoneNumberRegex = ".*\\s.*(?=.*\\b\\d{11}\\b).*";
    public boolean isVerifiedPhoneNumber(String phoneNumber) {
        return Pattern.compile(PhoneNumberRegex).
                matcher(phoneNumber).
                matches();
    }
}
