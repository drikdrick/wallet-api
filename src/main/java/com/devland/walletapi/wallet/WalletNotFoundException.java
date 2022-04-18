package com.devland.walletapi.wallet;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class WalletNotFoundException extends RuntimeException {
    public WalletNotFoundException() {
        super();
    }
}