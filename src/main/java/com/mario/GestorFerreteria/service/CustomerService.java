package com.mario.GestorFerreteria.service;

import com.mario.GestorFerreteria.model.Customer;
import com.mario.GestorFerreteria.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    //Busqueda
    public List<Customer>findCustomersByName(String name){
        return customerRepository.findCustomersByName(name);
    }

    //CRUD
    public List<Customer>findAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer findCustomerById(Long id){
        return customerRepository.findById(id).orElse(null);
    }

    public Customer addCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public void deleteCustomerById(Long id){
        customerRepository.deleteById(id);
    }

}
