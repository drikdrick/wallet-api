package com.devland.walletapi.customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public List<Customer> getAll(){
        return this.customerRepository.findAll();
    }

    public Customer createCustomer(Customer customer){
        return this.customerRepository.save(customer);
    }

    public Customer getOne(BigInteger id){
        Optional<Customer> optionalCustomer = this.customerRepository.findById(id);
        if (optionalCustomer.isEmpty()){
            throw new CustomerNotFoundException();
        }
        return  optionalCustomer.get();
    }

    public Customer updateCustomer(Customer customer){
        this.getOne(customer.getId());

        return this.customerRepository.save(customer);
    }

    public void deleteCustomer(Customer customer){
        Customer deletedCustomer = this.getOne(customer.getId());

        this.customerRepository.delete(deletedCustomer);
    }
}
