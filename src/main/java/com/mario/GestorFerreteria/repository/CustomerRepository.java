package com.mario.GestorFerreteria.repository;

import com.mario.GestorFerreteria.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.DefaultEditorKit;
import java.util.List;

@Repository

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findCustomersByName(String name);
}
