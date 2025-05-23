package ua.com.project.strategy;

import ua.com.project.model.Flight;

public interface PriceStrategy {
    double calculatePrice(Flight flight);
}
