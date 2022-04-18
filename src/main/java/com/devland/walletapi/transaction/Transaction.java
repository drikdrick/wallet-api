package com.devland.walletapi.transaction;

import java.math.BigInteger;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.devland.walletapi.wallet.Wallet;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
// @EqualsAndHashCode
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    private String description;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    private double amount;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

    private TransactionType type;

    public TransactionResponseDTO convertToResponse() {
        return TransactionResponseDTO.builder().id(this.id).description(this.description).target(this.wallet)
                .type(this.type).createdAt(this.createdAt).build();
    }

}
