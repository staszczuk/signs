package com.example.signs.repository.api;

import com.example.signs.entity.SignType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SignTypeRepository extends JpaRepository<SignType, UUID> {

}
