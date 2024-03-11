package com.example.signs.service.impl;

import com.example.signs.entity.SignType;
import com.example.signs.repository.api.SignTypeRepository;
import com.example.signs.service.api.SignTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SignTypeDefaultService implements SignTypeService {

    private final SignTypeRepository repository;

    public SignTypeDefaultService(SignTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(SignType signType) {
        repository.save(signType);
    }

    @Override
    public void delete(UUID id) {
        repository.findById(id)
                .ifPresent(repository::delete);
    }

    @Override
    public Optional<SignType> find(UUID id) {
        return repository.findById(id);
    }

    @Override
    public List<SignType> findAll() {
        return repository.findAll();
    }

    @Override
    public void update(SignType signType) {
        repository.save(signType);
    }

}
