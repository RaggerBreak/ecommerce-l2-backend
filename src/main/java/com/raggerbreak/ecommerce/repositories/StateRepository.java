package com.raggerbreak.ecommerce.repositories;

import com.raggerbreak.ecommerce.domain.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StateRepository extends JpaRepository<State, Long> {

    List<State> findAllByCountry_Code(String code);
}
