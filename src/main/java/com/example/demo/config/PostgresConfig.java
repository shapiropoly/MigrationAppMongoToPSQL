package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@Profile("postgres")
@EnableJpaRepositories(basePackages = "com.example.demo.repository.postgres")
public class PostgresConfig {}
