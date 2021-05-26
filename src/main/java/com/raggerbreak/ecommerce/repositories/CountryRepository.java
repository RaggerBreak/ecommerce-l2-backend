package com.raggerbreak.ecommerce.repositories;

import com.raggerbreak.ecommerce.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
    Country findByName(String name);
}
