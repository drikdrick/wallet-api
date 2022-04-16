package com.devland.walletapi.customer;

import com.devland.walletapi.wallet.Wallet;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    private String name;

    private String NIK;

    private Date dateOfBirth;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime customerCreatedAt;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "wallet_id", referencedColumnName = "id")
    private Wallet wallet;

    public CustomerResponseDTO convertToResponse() {
        return CustomerResponseDTO.builder()
                .id(this.id)
                .name(this.name)
                .NIK(this.NIK)
                .dateOfBirth(this.dateOfBirth)
                .customerCreatedAt(this.customerCreatedAt)
                .walletResponseDTO(this.wallet.convertToResponse())
                .build();
    }
}
