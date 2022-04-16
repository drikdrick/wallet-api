package com.devland.walletapi.wallet;

import com.devland.walletapi.transaction.Transaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class WalletResponseDTO {
    private BigInteger id;

    private double walletBalance;

    private List<Transaction> transactions;

    private LocalDateTime walletCreatedAt;

}
