package com.jiashu.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class SuhuiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SuhuiApplication.class, args);
    }
}
