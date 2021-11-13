package com.hackaceiba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(
        basePackages = { "com.hackaceiba"}
)
@SpringBootApplication
@EnableHystrix
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}
