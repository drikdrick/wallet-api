package com.devland.walletapi.transaction;

import java.math.BigInteger;
import java.time.LocalDateTime;

import javax.persistence.*;

import com.devland.walletapi.wallet.Wallet;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
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
    @JoinColumn(name = "target_id")
    @JsonIgnore
    private Wallet target;

    private TransactionType type;

    public TransactionResponseDTO convertToResponse(){
       return TransactionResponseDTO.builder().id(this.id).amount(this.amount).target(this.target).type(this.type).createdAt(this.createdAt).build();
    }
}
