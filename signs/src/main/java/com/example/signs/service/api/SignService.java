package com.example.signs.service.api;

import com.example.signs.entity.Sign;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SignService {

    void create(Sign sign);

    void delete(UUID id);

    Optional<Sign> find(UUID id);

    List<Sign> findAll();

    Optional<List<Sign>> findAllBySignType(UUID signTypeId);

    void update(Sign sign);

}
