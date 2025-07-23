package com.NextGenPay.service;
import com.NextGenPay.data.model.Cashier;
import com.NextGenPay.data.model.DebitTransactionHistory;
import com.NextGenPay.data.model.TransactionStatus;
import com.NextGenPay.data.model.Wallet;
import com.NextGenPay.data.repository.CashierRepo;
import com.NextGenPay.data.repository.DebitTransactionHistoryRepo;
import com.NextGenPay.data.repository.WalletRepository;
import com.NextGenPay.dto.request.ScanToPayRequest;
import com.NextGenPay.exception.WalletNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    WalletRepository walletRepo;
    @Autowired
    CashierRepo cashierRepo;
    @Autowired
    DebitTransactionHistoryRepo debitTransactionHistoryRepo;



    @Override
    public DebitTransactionHistory scanToPay(ScanToPayRequest request) {
        validator(request);
        Wallet customerWallet = walletRepo.findByCustomerId(request.getCustomerId());
        Cashier cashier = cashierRepo.findByCashierId(request.getCashierId());
        DebitTransactionHistory transactionHistory = new DebitTransactionHistory();

        customerWallet.setBalance(customerWallet.getBalance() - request.getAmount());
        walletRepo.save(customerWallet);
        transactionHistory.setAmount(request.getAmount());
        transactionHistory.setTransactionId("TXN" + System.currentTimeMillis());
        transactionHistory.setTransactionDate(LocalDate.now());
        transactionHistory.setStatus(TransactionStatus.COMPLETED);
        transactionHistory.setDescription("Debited from wallet");
        transactionHistory.setCashierId(cashier.getCashierId());
        return debitTransactionHistoryRepo.save(transactionHistory);
    }

    @Override
    public Wallet displayWallet(String customerId) {
        Wallet customerWallet = walletRepo.findByCustomerId(customerId);
        if (customerWallet == null) {throw new WalletNotFoundException("User with id " + customerId + " not found" );}
        return customerWallet;
    }

    private void validator(ScanToPayRequest request) {
        Cashier foundCashier = cashierRepo.findByCashierId(request.getCashierId());
        if(foundCashier == null){throw new IllegalArgumentException("Cashier not found");}
        if(request == null || request.getAmount() <= 0 || request.getAccountNumber() == null || request.getCashierId() == null) {throw new IllegalArgumentException("Invalid scan to pay request");}
        Wallet customerWallet = walletRepo.findByCustomerId(request.getCustomerId());
        if (customerWallet == null) {throw new IllegalArgumentException("Customer wallet not found");}
        if(customerWallet.getBalance() <= 0) {throw new IllegalArgumentException("Insufficient balance in wallet");}
        if(customerWallet.getBalance() < request.getAmount()) {throw new IllegalArgumentException("Insufficient balance in wallet for this transaction");}
    }
}
