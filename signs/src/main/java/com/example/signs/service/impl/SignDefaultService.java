package com.example.signs.service.impl;

import com.example.signs.entity.Sign;
import com.example.signs.repository.api.SignRepository;
import com.example.signs.service.api.SignService;
import com.example.signs.repository.api.SignTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SignDefaultService implements SignService {

    private final SignRepository repository;
    private final SignTypeRepository signTypeRepository;

    @Autowired
    public SignDefaultService(
            SignRepository repository,
            SignTypeRepository signTypeRepository
    ) {
        this.repository = repository;
        this.signTypeRepository = signTypeRepository;
    }

    @Override
    public void create(Sign sign) {
        repository.save(sign);
    }

    @Override
    public void delete(UUID id) {
        repository.findById(id)
                .ifPresent(repository::delete);
    }

    @Override
    public Optional<Sign> find(UUID id) {
        return repository.findById(id);
    }

    @Override
    public List<Sign> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<List<Sign>> findAllBySignType(UUID signTypeId) {
        return signTypeRepository.findById(signTypeId)
                .map(repository::findAllBySignType);
    }

    @Override
    public void update(Sign sign) {
        repository.save(sign);
    }

}
