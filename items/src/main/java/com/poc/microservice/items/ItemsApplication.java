package com.poc.microservice.items;

import com.poc.microservice.items.model.entity.Item;
import com.poc.microservice.items.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RefreshScope
@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@RequiredArgsConstructor
@EnableDiscoveryClient
public class ItemsApplication implements CommandLineRunner {
    private final ItemRepository itemRepository;

    public static void main(String[] args) {
        SpringApplication.run(ItemsApplication.class, args);
    }

    @Bean
    public AuditorAware<String> auditorAware() {return new AuditorAware<String>() {
        @Override
        public Optional<String> getCurrentAuditor() {
            return Optional.of("user");
        }
    };}

    @Override
    public void run(String... args) throws Exception {
    }
}
