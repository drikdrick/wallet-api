package com.devland.walletapi.transaction;

import java.math.BigInteger;

import com.devland.walletapi.wallet.Wallet;
import com.devland.walletapi.wallet.WalletService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class TransactionController {
    private TransactionService transactionService;
    private WalletService walletService;

    @PostMapping("/wallets/{id}/transactions")
    public ResponseEntity<TransactionResponseDTO> sendMoney(@PathVariable("id") BigInteger senderId,
            @RequestBody TransactionRequestDTO transactionRequestDTO) {
        Wallet sender = this.walletService.getOne(senderId);
        Wallet receiver = this.walletService.getOne(transactionRequestDTO.getReceiver());
        Transaction forSender = this.transactionService.send(sender, receiver, transactionRequestDTO.getAmount(),
                transactionRequestDTO.getDescription());
        TransactionResponseDTO transactionResponseDTO = forSender.convertToResponse();
        return ResponseEntity.ok(transactionResponseDTO);
    }
}
