package com.example.signs.cmd;

import com.example.signs.entity.Color;
import com.example.signs.entity.Shape;
import com.example.signs.entity.Sign;
import com.example.signs.service.api.SignService;
import com.example.signs.service.api.SignTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;
import java.util.UUID;

@Component
public class CMD implements CommandLineRunner {

    private final SignService signService;
    private final SignTypeService signTypeService;

    @Autowired
    public CMD(
            SignService signService,
            SignTypeService signTypeService
    ) {
        this.signService = signService;
        this.signTypeService = signTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String cmd;

        while (true) {
            cmd = scanner.next();

            switch (cmd) {
                case "help":
                    System.out.println("get_sign <uuid>");
                    System.out.println("get_all_signs");
                    System.out.println("get_all_signs_by_sign_type <uuid>");
                    System.out.println("put_sign <sign_type_uuid> <name> <code_postfix> <color> <shape>");
                    System.out.println("delete_sign <uuid>");
                    System.out.println("get_all_sign_types");
                    System.out.println("quit");
                    break;

                case "get_sign":
                    try {
                        UUID uuid = UUID.fromString(scanner.next());
                        signService.find(uuid).ifPresent(System.out::println);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid UUID");
                    }
                    break;

                case "get_all_signs":
                    signService.findAll().forEach(System.out::println);
                    break;

                case "get_all_signs_by_sign_type":
                    try {
                        UUID uuid = UUID.fromString(scanner.next());
                        signService.findAllBySignType(uuid)
                                .ifPresent(signs ->
                                        signs.forEach(System.out::println)
                                );
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid UUID");
                    }
                    break;

                case "get_all_sign_types":
                    signTypeService.findAll()
                            .forEach(System.out::println);
                    break;

                case "put_sign":
                    try {
                        UUID signTypeUUID = UUID.fromString(scanner.next());
                        signTypeService.find(signTypeUUID)
                                .ifPresent(signType ->
                                        signService.create(Sign.builder()
                                                .id(UUID.randomUUID())
                                                .name(scanner.next())
                                                .codePostfix(scanner.next())
                                                .color(Color.valueOf(scanner.next()))
                                                .shape(Shape.valueOf(scanner.next()))
                                                .signType(signType)
                                                .build()
                                        )
                                );
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid argument");
                    }
                    break;

                case "delete_sign":
                    try {
                        UUID uuid = UUID.fromString(scanner.next());
                        signService.delete(uuid);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid UUID");
                    }
                    break;

                case "quit":
                    System.exit(0);
                    break;

                default:
                    System.out.println("No such command");
                    System.out.println("Type help for help");
                    break;
            }
        }
    }

}
