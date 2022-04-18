package com.devland.walletapi.customer;

import com.devland.walletapi.wallet.WalletResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class CustomerResponseDTO {
    private BigInteger id;

    private String name;

    private String NIK;

    private Date dateOfBirth;

    private LocalDateTime customerCreatedAt;

    private WalletResponseDTO walletResponseDTO;
}
