package com.example.signtypes.service.impl;

import com.example.signtypes.entity.SignType;
import com.example.signtypes.event.repository.api.SignTypeEventRepository;
import com.example.signtypes.repository.api.SignTypeRepository;
import com.example.signtypes.service.api.SignTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SignTypeDefaultService implements SignTypeService {

    private final SignTypeEventRepository signTypeEventRepository;
    private final SignTypeRepository signTypeRepository;

    public SignTypeDefaultService(
            SignTypeEventRepository signTypeEventRepository,
            SignTypeRepository repository
    ) {
        this.signTypeEventRepository = signTypeEventRepository;
        this.signTypeRepository = repository;
    }

    @Override
    public void create(SignType signType) {
        signTypeRepository.save(signType);
        signTypeEventRepository.create(signType);
    }

    @Override
    public void delete(UUID id) {
        signTypeRepository.findById(id)
                .ifPresent(signTypeRepository::delete);
        signTypeEventRepository.delete(id);
    }

    @Override
    public Optional<SignType> find(UUID id) {
        return signTypeRepository.findById(id);
    }

    @Override
    public List<SignType> findAll() {
        return signTypeRepository.findAll();
    }

    @Override
    public void update(SignType signType) {
        signTypeRepository.save(signType);
    }

}
