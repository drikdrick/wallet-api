package com.devland.walletapi.wallet;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WalletRequestDTO {
    // TODO
    // Apakah wallet request perlu id?
    private double walletBalance;

    public Wallet convertToEntity() {
        return Wallet.builder()
                .walletBalance(this.walletBalance).build();
    }
}
