package com.amortization.mortgage;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Repository
public class JdbcValueTrackerRepository implements ValueTrackerRepository {

    private final JdbcClient jdbcClient;

    public JdbcValueTrackerRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<ValueTracker> findAll() {
        return jdbcClient.sql("select * from valueTracker")
                .query(ValueTracker.class)
                .list();
    }

    public Optional<ValueTracker> findById(Integer id) {
        return jdbcClient.sql("SELECT id,date,interestAtCurrentMonth,principalAtCurrentMonth,totalInterest,totalPrincipal FROM ValueTracker WHERE id = :id" )
                .param("id", id)
                .query(ValueTracker.class)
                .optional();
    }

    public void create(ValueTracker valueTracker) {
        var updated = jdbcClient.sql("INSERT INTO Run(id,title,started_on,completed_on,miles,location) values(?,?,?,?,?,?)")
                .params(List.of(valueTracker.getId(),valueTracker.getMyUser(),valueTracker.getEmail(),valueTracker.getPaymentPeroid(),valueTracker.getInterestAtCurrentMonth(),valueTracker.getPrincipaltAtCurrentMonth(),valueTracker.getTotalInterest(),valueTracker.getTotalPrincipal()).toString())
                .update();

        Assert.state(updated == 1, "Failed to create valueTracker " + valueTracker.getMyUser());
    }

    public void update(ValueTracker valueTracker, Integer id) {
        var updated = jdbcClient.sql("update valueTracker set date = ?, monthlyInterest = ?, monthlyPrincipal = ?, totalInterest = ?, totalPrincipal = ? where id = ?")
                .params(List.of(valueTracker.getPaymentPeroid(),valueTracker.getInterestAtCurrentMonth(),valueTracker.getPrincipaltAtCurrentMonth(),valueTracker.getTotalInterest(),valueTracker.getTotalPrincipal()).toString(), id)
                .update();

        Assert.state(updated == 1, "Failed to update valueTracker " + valueTracker.getMyUser());
    }

    public void delete(Integer id) {
        var updated = jdbcClient.sql("delete from valueTracker where id = :id")
                .param("id", id)
                .update();

        Assert.state(updated == 1, "Failed to delete valueTracker " + id);
    }

    public int count() {
        return jdbcClient.sql("select * from valueTracker").query().listOfRows().size();
    }

    public void saveAll(List<ValueTracker> valueTrackers) {
        valueTrackers.stream().forEach(this::create);
    }

    public List<ValueTracker> findByPaymentPeriod(int paymentperiod) {
        return jdbcClient.sql("select * from run where paymentPeriod = :paymentPeriod")
                .param("paymentPeriod", paymentperiod)
                .query(ValueTracker.class)
                .list();
    }

}