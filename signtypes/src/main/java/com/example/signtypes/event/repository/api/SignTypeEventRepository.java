package com.example.signtypes.event.repository.api;

import com.example.signtypes.entity.SignType;

import java.util.UUID;

public interface SignTypeEventRepository {

    void create(SignType signType);

    void delete(UUID id);

}
