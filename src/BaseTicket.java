public class BaseTicket implements Ticket {
    private Client client;
    private Flight flight;
    private boolean withLuggage;
    private boolean priorityBoarding;
    private double price;

    public BaseTicket(Client client, Flight flight, boolean withLuggage, boolean priorityBoarding) {
        this.client = client;
        this.flight = flight;
        this.withLuggage = withLuggage;
        this.priorityBoarding = priorityBoarding;
        this.price = calculateTicketPrice(withLuggage, priorityBoarding);
    }

    @Override
    public String getDescription() {
        return "Ticket for " + client.getName();
    }

    @Override
    public double getTicketPrice() {
        return flight.calculatePrice();
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "client=" + client +
                ", flight=" + flight +
                ", withLuggage=" + withLuggage +
                ", priorityBoarding=" + priorityBoarding +
                ", price=" + price +
                '}';
    }

    private double calculateTicketPrice(boolean withLuggage, boolean priorityBoarding) {
        double ticketCalculatedPrice = flight.calculatePrice();
        if (withLuggage) ticketCalculatedPrice += 40;
        if (priorityBoarding) ticketCalculatedPrice += 15;

        return ticketCalculatedPrice;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public boolean isWithLuggage() {
        return withLuggage;
    }

    public void setWithLuggage(boolean withLuggage) {
        this.withLuggage = withLuggage;
    }

    public boolean isPriorityBoarding() {
        return priorityBoarding;
    }

    public void setPriorityBoarding(boolean priorityBoarding) {
        this.priorityBoarding = priorityBoarding;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
