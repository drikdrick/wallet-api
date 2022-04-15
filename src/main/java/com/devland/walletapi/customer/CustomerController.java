package com.devland.walletapi.customer;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class CustomerController {
    private CustomerService customerService;

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerResponseDTO>> getCustomers(){
        List<Customer> customers = this.customerService.getAll();

        List<CustomerResponseDTO> customerResponseDTOS = customers.stream()
                .map(customer -> customer.convertToResponse())
                .collect(Collectors.toList());

        return ResponseEntity.ok(customerResponseDTOS);
    }

    @PostMapping("/customer")
    public ResponseEntity<CustomerResponseDTO> createCustomer(@RequestBody CustomerRequestDTO customerRequestDTO){
        Customer newCustomer = customerRequestDTO.convertToEntity();

        Customer customer = this.customerService.createCustomer(newCustomer);
        CustomerResponseDTO customerResponseDTO = customer.convertToResponse();

        return ResponseEntity.status(HttpStatus.CREATED).body(customerResponseDTO);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<CustomerResponseDTO> getCustomer(@PathVariable("id")BigInteger id){
        Customer customer = customerService.getOne(id);

        CustomerResponseDTO customerResponseDTO = customer.convertToResponse();

        return ResponseEntity.ok(customerResponseDTO);
    }

    @PutMapping("/customer/{id}")
    public ResponseEntity<CustomerResponseDTO> updateCustomer(@PathVariable("id")BigInteger id, @RequestBody CustomerRequestDTO customerRequestDTO){
        Customer customer =customerRequestDTO.convertToEntity();
        customer.setId(id);

        Customer updatedCustomer = customerService.updateCustomer(customer);

        return ResponseEntity.ok(updatedCustomer.convertToResponse());

    }

}
