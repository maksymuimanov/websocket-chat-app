package io.maksymuimanov.history;

import org.springframework.boot.SpringApplication;

public class TestChatHistoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.from(HistoryApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
