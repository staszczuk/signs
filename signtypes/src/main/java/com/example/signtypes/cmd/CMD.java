package com.example.signtypes.cmd;

import com.example.signtypes.service.api.SignTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CMD implements CommandLineRunner {

    private final SignTypeService signTypeService;

    @Autowired
    public CMD(SignTypeService signTypeService) {
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
                    System.out.println("get_all_sign_types");
                    System.out.println("quit");
                    break;

                case "get_all_sign_types":
                    signTypeService.findAll()
                            .forEach(System.out::println);
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
