package com.NextGenPay.service;

import com.NextGenPay.dto.request.GenerateWalletRequest;
import com.NextGenPay.dto.response.GenerateWalletResponse;

public interface GenerateWalletServiceAuth {
    GenerateWalletResponse generateWallet(GenerateWalletRequest request);
}
