package com.daofab.assignment.config;

import com.daofab.assignment.dtos.ChildJson;
import com.daofab.assignment.dtos.ParentJson;
import com.daofab.assignment.repositories.ChildRepository;
import com.daofab.assignment.repositories.ParentRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author prabesh on 25/Jan/2022
 */
@Component
public class StartupSeeder implements ApplicationListener<ContextRefreshedEvent> {

    private final ParentRepository parentRepository;
    private final ChildRepository childRepository;

    public StartupSeeder(ParentRepository parentRepository, ChildRepository childRepository) {
        this.parentRepository = parentRepository;
        this.childRepository = childRepository;
    }

    @SneakyThrows
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        createTableParent();
        createTableChild();
    }

    private void createTableParent() throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("Parent.json");
        InputStream inputStream = classPathResource.getInputStream();
        ObjectMapper mapper = new ObjectMapper();
        ParentJson parentJson = mapper.readValue(inputStream, new TypeReference<>() {
        });
        this.parentRepository.saveAll(parentJson.getData());
    }
    private void createTableChild() throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("Child.json");
        InputStream inputStream = classPathResource.getInputStream();
        ObjectMapper mapper = new ObjectMapper();
        ChildJson childJson = mapper.readValue(inputStream, new TypeReference<>() {
        });
        this.childRepository.saveAll(childJson.getData());
    }
}
