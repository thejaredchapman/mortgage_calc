package com.amortization.mortgage;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class ValueTrackerJsonDataLoader implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(ValueTrackerJsonDataLoader.class);
    private final ObjectMapper objectMapper;
    private final ValueTrackerRepository valueTrackerRepository;

    public ValueTrackerJsonDataLoader(ObjectMapper objectMapper, @Qualifier("jdbcValueTrackerRepository") ValueTrackerRepository valueTrackerRepository) {
        this.objectMapper = objectMapper;
        this.valueTrackerRepository = valueTrackerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(valueTrackerRepository.count() == 0) {
            try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/runs.json")) {
                ValueTrackers allValueTrackers = objectMapper.readValue(inputStream, ValueTrackers.class);
                log.info("Reading {} valueTrackers from JSON data and saving to in-memory collection.", allValueTrackers.valueTrackers().size());
                valueTrackerRepository.saveAll(allValueTrackers.valueTrackers());
            } catch (IOException e) {
                throw new RuntimeException("Failed to read JSON data", e);
            }
        } else {
            log.info("Not loading ValueTrackers from JSON data because the collection contains data.");
        }
    }

}