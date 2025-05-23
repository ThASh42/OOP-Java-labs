package ua.com.project.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean withLuggage;
    private boolean priorityBoarding;
    private double price;

    @ManyToOne
    private Client client;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;

    public Ticket() {
    }

    public Ticket(boolean withLuggage, boolean priorityBoarding, double price, Flight flight) {
        this.withLuggage = withLuggage;
        this.priorityBoarding = priorityBoarding;
        this.price = price;
        this.flight = flight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}

