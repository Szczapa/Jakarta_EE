package org.example.api.entity;

import jakarta.enterprise.inject.Produces;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CarProducer {
    @Produces
    @ApplicationScoped
    public List<Car> produceCarList() {
        return new ArrayList<>();
    }
}
