package com.devland.walletapi.transaction;

import java.math.BigInteger;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class TransactionRequestDTO {
    private String description;

    private double amount;

    // private Wallet receiver;

    // private Wallet sender;

    private BigInteger receiver;
}
