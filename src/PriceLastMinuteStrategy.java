public class PriceLastMinuteStrategy implements PriceStrategy {
    @Override
    public double calculatePrice(Flight flight) {
        return 50.0 + flight.getBasePrice();
    }
}
