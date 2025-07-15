package com.NextGenPay.util;
import org.springframework.stereotype.Service;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class Otp {

    private final ConcurrentHashMap<String, String> otpStorage = new ConcurrentHashMap<>();
    private static final int OTP_LENGTH = 6;
    private static final long OTP_VALID_DURATION = 5 * 60 * 1000; // 5 minutes

    public String generateOTP(String email) {
        Random random = new Random();
        StringBuilder otp = new StringBuilder();
        for (int i = 0; i < OTP_LENGTH; i++) {
            otp.append(random.nextInt(10));
        }
        otpStorage.put(email, otp.toString());
        return otp.toString();
    }

    public boolean verifyOTP(String email, String otp) {
        String storedOtp = otpStorage.get(email);
        if (storedOtp != null && storedOtp.equals(otp)) {
            otpStorage.remove(email);
            return true;
        }
        return false;
    }

    public String verifyOTPAndGenerateToken(String email, String otp) {
        if (!verifyOTP(email, otp)) {
            throw new RuntimeException("Invalid OTP");
        }
        return "TOKEN-" + System.currentTimeMillis();
    }
}
