package com.example.signs.repository.api;

import com.example.signs.entity.Sign;
import com.example.signs.entity.SignType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SignRepository extends JpaRepository<Sign, UUID> {

    List<Sign> findAllBySignType(SignType signType);

}
