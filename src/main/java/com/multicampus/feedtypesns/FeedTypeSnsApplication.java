package com.multicampus.feedtypesns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class FeedTypeSnsApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeedTypeSnsApplication.class, args);
    }

}
