package com.amortization.mortgage;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestParam;

public interface ValueTrackerRepository {
    
    List<ValueTracker> findAll();

    Optional<ValueTracker> findById(Integer id);

    void create(ValueTracker valueTracker);

    void update(ValueTracker valueTracker, Integer id);

    void delete(Integer id);

    int count();

    void saveAll(List<ValueTracker> valueTrackers);

    List<ValueTracker> findByPaymentPeriod(@RequestParam int paymentPeroid);
}
