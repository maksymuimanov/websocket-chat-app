package io.chatapp.historyservice;

import io.chatapp.history.HistoryServiceApplication;
import org.springframework.boot.SpringApplication;

public class TestHistoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.from(HistoryServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
