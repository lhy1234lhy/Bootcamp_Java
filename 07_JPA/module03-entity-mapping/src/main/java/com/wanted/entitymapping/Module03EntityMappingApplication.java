package com.wanted.entitymapping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.wanted")
public class Module03EntityMappingApplication {

    public static void main(String[] args) {
        SpringApplication.run(Module03EntityMappingApplication.class, args);
    }

}
