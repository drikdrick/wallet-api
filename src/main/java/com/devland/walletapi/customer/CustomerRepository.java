package com.devland.walletapi.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, BigInteger> {
    Customer findByNIK(String nIK);
}
