package com.example.signtypes.event.repository.impl;

import com.example.signtypes.entity.SignType;
import com.example.signtypes.event.repository.api.SignTypeEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Repository
public class SignTypeRestRepository implements SignTypeEventRepository {

    private final RestTemplate restTemplate;

    @Autowired
    public SignTypeRestRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void create(SignType signType) {
        restTemplate.put("/api/signtypes/" + signType.getId(), signType.getId());
    }

    @Override
    public void delete(UUID id) {
        restTemplate.delete("/api/signtypes/{id}", id);
    }

}
