package com.devland.walletapi.wallet;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WalletRequestDTO {

    private double walletBalance;

    public Wallet convertToEntity(){
        return Wallet.builder()
                .walletBalance(this.walletBalance).build();
    }
}
