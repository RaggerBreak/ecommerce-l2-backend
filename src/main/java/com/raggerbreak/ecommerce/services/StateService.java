package com.raggerbreak.ecommerce.services;

import com.raggerbreak.ecommerce.domain.State;

import java.util.List;

public interface StateService {
    List<State> getAllByCountry(String code);
}
