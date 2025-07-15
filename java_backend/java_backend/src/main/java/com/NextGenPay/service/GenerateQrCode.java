package com.NextGenPay.service;
import org.springframework.stereotype.Service;




@Service
public interface GenerateQrCode {

    String generateQrCode(String data);

}
