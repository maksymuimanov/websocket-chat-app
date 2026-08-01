package io.maksymuimanov.chat;

import org.springframework.boot.SpringApplication;

public class TestChatServiceApplication {

    public static void main(String[] args) {
        SpringApplication.from(ChatApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
