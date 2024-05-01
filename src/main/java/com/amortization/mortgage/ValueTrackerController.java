package com.amortization.mortgage;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JacksonInject.Value;

@RestController
@RequestMapping("/api/mortgages")
class ValueTrackerController {
    
    private final JdbcValueTrackerRepository valueTrackerRepository;

    ValueTrackerController(JdbcValueTrackerRepository valueTrackerRepository) {
        this.valueTrackerRepository = valueTrackerRepository;
    }

    @GetMapping
    List<ValueTracker> findAll() {
        return valueTrackerRepository.findAll();
    }
 

    @GetMapping("/{id}")
    ValueTracker findById(@PathVariable Integer id) {
        Optional<ValueTracker> valueTracker = valueTrackerRepository.findById(id);
        if(valueTracker.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ValueTracker not found.");
        }
        return valueTracker.get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    void create(@Valid @RequestBody ValueTracker valueTracker) {
        valueTrackerRepository.create(valueTracker);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@Valid @RequestBody ValueTracker valueTracker, @PathVariable Integer id) {
        valueTrackerRepository.update(valueTracker,id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        valueTrackerRepository.delete(id);
    }

}
