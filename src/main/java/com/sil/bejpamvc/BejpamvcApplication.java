package com.sil.bejpamvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BejpamvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(BejpamvcApplication.class, args);
    }

}
