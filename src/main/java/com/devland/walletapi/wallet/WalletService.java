package com.devland.walletapi.wallet;

import java.math.BigInteger;

import com.devland.walletapi.transaction.TransactionService;
import com.devland.walletapi.transaction.TransactionType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class WalletService {
    private final WalletRepository walletRepository;

    @Autowired
    private TransactionService transactionService;

    public Wallet getOne(BigInteger id) {
        return this.walletRepository.findById(id).orElseThrow(() -> new WalletNotFoundException());
    }

    public Wallet update(Wallet wallet) {
        this.getOne(wallet.getId());
        return this.walletRepository.save(wallet);
    }

    public void checkBalance(Wallet wallet, Double amount) {
        if (wallet.getWalletBalance() - amount < 0) {
            throw new InsufficientWalletBalanceException();
        }
    }

    public void addBalance(BigInteger id, Double amount) {
        Wallet wallet = this.getOne(id);
        wallet.setWalletBalance(wallet.getWalletBalance() + amount);
        this.update(wallet);
        this.transactionService.create(wallet, TransactionType.IN, amount);
    }

    public void takeBalance(BigInteger id, Double amount) {
        Wallet wallet = this.getOne(id);
        this.checkBalance(wallet, amount);
        wallet.setWalletBalance(wallet.getWalletBalance() - amount);
        this.update(wallet);
        this.transactionService.create(wallet, TransactionType.OUT, amount);
    }

    public void transfer(Wallet sender, Wallet receiver, Double amount) {
        this.takeBalance(sender.getId(), amount);
        this.addBalance(receiver.getId(), amount);
    }
}
