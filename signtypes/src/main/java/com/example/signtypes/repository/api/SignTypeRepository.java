package com.example.signtypes.repository.api;

import com.example.signtypes.entity.SignType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SignTypeRepository extends JpaRepository<SignType, UUID> {

}
