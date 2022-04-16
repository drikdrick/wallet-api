package com.devland.walletapi.wallet;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, BigInteger> {

}
