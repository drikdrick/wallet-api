package com.devland.walletapi.wallet;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InsufficientWalletBalanceException extends RuntimeException {
    public InsufficientWalletBalanceException() {
        super("Insufficient Wallet Balance. Transaction failed.");
    }
}
