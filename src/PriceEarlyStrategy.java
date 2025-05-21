public class PriceEarlyStrategy implements PriceStrategy {
    @Override
    public double calculatePrice(Flight flight) {
        return 0.0 + flight.getBasePrice();
    }
}
