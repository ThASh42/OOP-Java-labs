public class Ticket {
    private Client client;
    private Flight flight;
    private boolean withLuggage;
    private boolean priorityBoarding;
    private double price;

    public Ticket(Client client, Flight flight, boolean withLuggage, boolean priorityBoarding, double price) {
        this.client = client;
        this.flight = flight;
        this.withLuggage = withLuggage;
        this.priorityBoarding = priorityBoarding;
        this.price = price;
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
