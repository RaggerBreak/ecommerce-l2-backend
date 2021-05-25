package com.raggerbreak.ecommerce.services;

import com.raggerbreak.ecommerce.domain.State;
import com.raggerbreak.ecommerce.repositories.StateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StateServiceImpl implements StateService {

    private final StateRepository stateRepository;

    @Override
    public List<State> getAllByCountry(String code) {
        return stateRepository.findAllByCountry_Code(code);
    }
}
