package com.luan.luanfood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.luan.luanfood.infrastructure.repository.CustomJpaRepositoryImpl;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomJpaRepositoryImpl.class)
public class LuanfoodApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(LuanfoodApiApplication.class, args);
    }

}
