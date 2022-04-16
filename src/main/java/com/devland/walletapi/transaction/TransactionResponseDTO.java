package com.devland.walletapi.transaction;

import java.math.BigInteger;
import java.time.LocalDateTime;

import com.devland.walletapi.wallet.Wallet;

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
public class TransactionResponseDTO {
    private BigInteger id;

    private String description;

    private LocalDateTime createdAt;

    private double amount;

    private Wallet target;

    private TransactionType type;
}
