package com.example.signs.init;

import com.example.signs.entity.Color;
import com.example.signs.entity.Shape;
import com.example.signs.entity.Sign;
import com.example.signs.entity.SignType;
import com.example.signs.service.api.SignService;
import com.example.signs.service.api.SignTypeService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Init implements InitializingBean {

    private final SignService signService;
    private final SignTypeService signTypeService;

    @Autowired
    public Init(
            SignService signService,
            SignTypeService signTypeService
    ) {
        this.signService = signService;
        this.signTypeService = signTypeService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        SignType warningSignType = SignType.builder()
                .id(UUID.fromString("f885cb6b-9140-4fdd-8f95-d1d7f1b1ad5e"))
                .build();

        signTypeService.create(warningSignType);

        warningSignType.addSign(
                Sign.builder()
                        .id(UUID.fromString("280d8971-d759-491f-8750-5906181431fa"))
                        .name("dangerous curve to the right")
                        .codePostfix("1")
                        .color(Color.YELLOW)
                        .shape(Shape.TRIANGULAR)
                        .build()
        );

        warningSignType.addSign(
                Sign.builder()
                        .id(UUID.fromString("772fe07e-c2eb-4dc6-bb50-5b9d016826f4"))
                        .name("give way")
                        .codePostfix("7")
                        .color(Color.YELLOW)
                        .shape(Shape.TRIANGULAR)
                        .build());

        warningSignType.addSign(
                Sign.builder()
                        .id(UUID.fromString("b7e5a172-0705-4622-a958-92981e48dd2c"))
                        .name("intersection - uncontrolled intersection")
                        .codePostfix("5")
                        .color(Color.YELLOW)
                        .shape(Shape.TRIANGULAR)
                        .build());

        warningSignType.addSign(
                Sign.builder()
                        .id(UUID.fromString("5989270c-335d-48f7-a227-d619edfcabe9"))
                        .name("traffic lights ahead")
                        .codePostfix("29")
                        .color(Color.YELLOW)
                        .shape(Shape.TRIANGULAR)
                        .build());

        warningSignType.getSigns()
                .forEach(signService::create);
    }

}
