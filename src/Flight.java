import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Flight {
    private String flightNumber;
    private LocalDate departureDate;
    private int totalSeats;
    private int bookedSeats = 0;
    private double basePrice;
    private List<BaseTicket> tickets = new ArrayList<>();
    private PriceStrategy priceStrategy;

    public Flight(String flightNumber, LocalDate departureDate, int totalSeats, double basePrice) {
        this.flightNumber = flightNumber;
        this.departureDate = departureDate;
        this.totalSeats = totalSeats;
        this.basePrice = basePrice;
    }

    public boolean hasAvailableSeats() {
        return bookedSeats < totalSeats;
    }

    public double calculatePrice() {
        selectStrategy();
        return priceStrategy.calculatePrice(this);
    }

    private void selectStrategy() {
        long daysUntilFlight = ChronoUnit.DAYS.between(LocalDate.now(), departureDate);
        double loadFactor = (double) bookedSeats / totalSeats;
        System.out.println("daysUntilFlight: " + daysUntilFlight);
        if (daysUntilFlight > 7 && loadFactor < 0.5) {
            priceStrategy = new PriceEarlyStrategy();
        } else if (daysUntilFlight <= 7 || loadFactor >= 0.8) {
            priceStrategy = new PriceLastMinuteStrategy();
        } else {
            priceStrategy = new PriceMediumStrategy();
        }
    }

    public BaseTicket bookTicket(Client client, boolean withLuggage, boolean priorityBoarding) {
        if (!hasAvailableSeats()) return null;

        BaseTicket ticket = new BaseTicket(client, this, withLuggage, priorityBoarding);
        tickets.add(ticket);
        bookedSeats++;
        return ticket;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber='" + flightNumber + '\'' +
                ", departureDate=" + departureDate +
                ", totalSeats=" + totalSeats +
                ", bookedSeats=" + bookedSeats +
                ", basePrice=" + basePrice +
                '}';
    }

    public void setPriceStrategy(PriceStrategy priceStrategy) {
        this.priceStrategy = priceStrategy;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(int bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public List<BaseTicket> getTickets() {
        return tickets;
    }

    public void setTickets(List<BaseTicket> tickets) {
        this.tickets = tickets;
    }
}
