package ua.com.project.strategy;

import ua.com.project.model.Flight;

public class PriceMediumStrategy implements PriceStrategy {
    @Override
    public double calculatePrice(Flight flight) {
        return 20.0 + flight.getBasePrice();
    }
}
