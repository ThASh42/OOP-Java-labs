package ua.com.project.entity;

import lombok.Getter;
import lombok.Setter;
import ua.com.project.strategy.PriceStrategy;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String flightNumber;
    private LocalDate departureDate;
    private int totalSeats;
    private int bookedSeats = 0;
    private double basePrice;

    @OneToMany(mappedBy = "flight")
    private List<Ticket> tickets = new ArrayList<>();

    @Transient
    private PriceStrategy priceStrategy;

    public Flight() {

    }

    public Flight(String flightNumber, LocalDate departureDate, int totalSeats, double basePrice) {
        this.flightNumber = flightNumber;
        this.departureDate = departureDate;
        this.totalSeats = totalSeats;
        this.basePrice = basePrice;
        this.bookedSeats = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public PriceStrategy getPriceStrategy() {
        return priceStrategy;
    }

    public void setPriceStrategy(PriceStrategy priceStrategy) {
        this.priceStrategy = priceStrategy;
    }
}
