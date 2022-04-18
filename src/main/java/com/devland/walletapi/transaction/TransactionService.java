package com.devland.walletapi.transaction;

import java.util.List;

import com.devland.walletapi.wallet.Wallet;
import com.devland.walletapi.wallet.WalletService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private WalletService walletService;

    public List<TransactionResponseDTO> getAll() {
        return this.transactionRepository.findAll().stream().map(Transaction::convertToResponse).toList();
    }

    public Transaction create(Wallet wallet, TransactionType type, Double amount, String description) {
        Transaction transaction = Transaction.builder().wallet(wallet).type(type).amount(amount)
                .description(description).build();
        return this.transactionRepository.save(transaction);
    }

    public Transaction send(Wallet sender, Wallet receiver, Double amount, String description) {
        this.walletService.transfer(sender, receiver, amount);
        Transaction forSender = this.create(sender, TransactionType.OUT, amount, description);
        this.create(receiver, TransactionType.IN, amount, description);
        return forSender;
    }
}
