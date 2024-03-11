package com.example.signs.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
@Entity
@Table(name = "signs")
public class Sign {

    @Id
    private UUID id;

    @Column(name = "code_postfix")
    private String codePostfix;

    private Color color;
    private String name;
    private Shape shape;

    @ManyToOne
    @JoinColumn(name = "sign_type_uuid")
    private SignType signType;

}
