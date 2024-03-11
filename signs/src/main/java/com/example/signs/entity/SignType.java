package com.example.signs.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
@Entity
@Table(name = "sign_types")
public class SignType {

    @Id
    private UUID id;

    @Builder.Default
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "signType", cascade = CascadeType.REMOVE)
    private List<Sign> signs = new ArrayList<>();

    public void addSign(Sign sign) {
        this.signs.add(sign);
        sign.setSignType(this);
    }

}
