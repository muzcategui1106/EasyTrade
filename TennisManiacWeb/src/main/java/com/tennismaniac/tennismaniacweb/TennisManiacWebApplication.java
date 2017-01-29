package com.tennismaniac.tennismaniacweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class TennisManiacWebApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TennisManiacWebApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(TennisManiacWebApplication.class, args);
    }
}
