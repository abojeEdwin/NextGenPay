package com.NextGenPay.exception;

public class InvalidLoginCredentials extends RuntimeException {
    public InvalidLoginCredentials(String message) {
        super(message);
    }
}
