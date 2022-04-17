package com.devland.walletapi.transaction;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {
    private TransactionService transactionService;

    @PostMapping("/transaction")
    public ResponseEntity<TransactionResponseDTO> createTransaction(@RequestBody TransactionRequestDTO transactionRequestDTO){
        Transaction newTransaction = transactionRequestDTO.convertToEntity();

        Transaction transaction = this.transactionService.createTransaction(newTransaction);
        TransactionResponseDTO transactionResponseDTO = transaction.convertToResponse();

        return ResponseEntity.ok(transactionResponseDTO);

    }
}
