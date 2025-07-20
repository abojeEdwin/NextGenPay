package com.NextGenPay.controller;
import com.NextGenPay.data.model.DebitTransactionHistory;
import com.NextGenPay.dto.request.ScanToPayRequest;
import com.NextGenPay.service.CustomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer-service")
@AllArgsConstructor
public class CustomerServiceController {

    @Autowired
    private CustomerService customerService;


    @PostMapping("/scan-to-pay")
    public ResponseEntity<DebitTransactionHistory> scanToPay(@RequestBody @Valid ScanToPayRequest request){
        return ResponseEntity.ok(customerService.scanToPay(request));
    }

    @PostMapping("/display-wallet")
    public ResponseEntity<?> displayWallet(@RequestBody @Valid String customerId){
        return ResponseEntity.ok(customerService.displayWallet(customerId));
    }
}
