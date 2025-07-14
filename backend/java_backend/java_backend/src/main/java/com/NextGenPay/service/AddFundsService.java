package com.NextGenPay.service;

import com.NextGenPay.dto.request.AddFundsRequest;
import com.NextGenPay.dto.response.AddFundsResponse;

public interface AddFundsService {
    AddFundsResponse addFunds(AddFundsRequest request);
}
