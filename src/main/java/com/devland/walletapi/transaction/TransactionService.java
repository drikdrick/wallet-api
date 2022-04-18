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

    // @Autowired
    // private WalletService walletService;

    public List<TransactionResponseDTO> getAll() {
        return this.transactionRepository.findAll().stream().map(Transaction::convertToResponse).toList();
    }

    public TransactionResponseDTO create(Wallet wallet, TransactionType type, Double amount) {
        Transaction transaction = Transaction.builder().target(wallet).type(type).amount(amount).build();
        return this.transactionRepository.save(transaction).convertToResponse();
    }
}
