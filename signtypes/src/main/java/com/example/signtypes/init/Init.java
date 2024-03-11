package com.example.signtypes.init;

import com.example.signtypes.entity.SignType;
import com.example.signtypes.service.api.SignTypeService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Init implements InitializingBean {

    private final SignTypeService signTypeService;

    @Autowired
    public Init(SignTypeService signTypeService) {
        this.signTypeService = signTypeService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        SignType warningSignType = SignType.builder()
                .id(UUID.fromString("f885cb6b-9140-4fdd-8f95-d1d7f1b1ad5e"))
                .name("Warning Sign Type")
                .codePrefix('A')
                .build();
        signTypeService.create(warningSignType);

        SignType prohibitorySignType = SignType.builder()
                .id(UUID.fromString("a8db4bfc-ba33-4b5e-b7d4-1b9de8160f9a"))
                .name("Prohibitory Sign Type")
                .codePrefix('B')
                .build();
        signTypeService.create(prohibitorySignType);
    }

}
