package com.devland.walletapi.wallet;

import com.devland.walletapi.transaction.Transaction;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double walletBalance;

    @OneToMany(mappedBy = "wallet")
    private List<Transaction> transactions;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime walletCreatedAt;

    public WalletResponseDTO convertToResponse() {
        return WalletResponseDTO.builder().id(this.id)
                .walletBalance(this.walletBalance)
                .transactions(this.transactions)
                .walletCreatedAt(this.walletCreatedAt).build();
    }

}
