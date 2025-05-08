import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Flight {
    private String flightNumber;
    private LocalDate departureDate;
    private int totalSeats;
    private int bookedSeats = 0;
    private double basePrice;
    private List<Ticket> tickets = new ArrayList<>();

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
        double price = basePrice;
        long daysUntilFlight = LocalDate.now().until(departureDate).getDays();

        if (daysUntilFlight < 7) {
            price *= 1.5;
        } else if ((double) bookedSeats / totalSeats > 0.8) {
            price *= 1.3;
        }

        return price;
    }

    public Ticket bookTicket(Client client, boolean withLuggage, boolean priorityBoarding) {
        if (!hasAvailableSeats()) return null;

        double price = calculatePrice();
        if (withLuggage) price += 40;
        if (priorityBoarding) price += 15;

        Ticket ticket = new Ticket(client, this, withLuggage, priorityBoarding, price);
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

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
