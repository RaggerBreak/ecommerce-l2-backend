package com.raggerbreak.ecommerce.repositories;

import com.raggerbreak.ecommerce.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
