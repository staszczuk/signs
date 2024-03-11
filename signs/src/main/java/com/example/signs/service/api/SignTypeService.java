package com.example.signs.service.api;

import com.example.signs.entity.SignType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SignTypeService {

    void create(SignType signType);

    void delete(UUID id);

    Optional<SignType> find(UUID id);

    List<SignType> findAll();

    void update(SignType signType);

}
