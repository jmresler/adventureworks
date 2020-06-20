package org.jmresler.aw.sales.repositories;

import java.util.Optional;

import org.jmresler.spring.aw.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByAccountNumber(String accountNumber);

    Optional<Customer> findByCustomerID(Long id);

    Optional<Customer> findByPersonID(Long id);
}
