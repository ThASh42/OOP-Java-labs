public class PriceMediumStrategy implements PriceStrategy {
    @Override
    public double calculatePrice(Flight flight) {
        return 20.0 + flight.getBasePrice();
    }
}
