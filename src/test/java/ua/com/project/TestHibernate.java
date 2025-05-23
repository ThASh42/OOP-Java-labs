package ua.com.project;

import org.junit.Test;
import ua.com.project.config.Factory;
import ua.com.project.dao.ClientDao;
import ua.com.project.dao.FlightDao;
import ua.com.project.dao.TicketDao;
import ua.com.project.entity.Client;
import ua.com.project.entity.Flight;
import ua.com.project.entity.Ticket;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class TestHibernate {

    private Factory factory = Factory.getInstance();

    @Test
    public void testFlightAndTicket() {
        ClientDao clientDao = factory.getClientDao();
        Client ivanClient = new Client();
        ivanClient.setFirstName("Іван");
        ivanClient.setLastName("Івановіч");

        clientDao.save(ivanClient);

        FlightDao flightDao = factory.getFlightDao();

        Flight flight = new Flight();
        flight.setFlightNumber("LC123");
        flight.setDepartureDate(LocalDate.now().plusDays(5));
        flight.setTotalSeats(100);
        flight.setBasePrice(99.99);

        flightDao.save(flight);

        Flight retrievedFlight = flightDao.findById(1L);
        assertEquals("LC123", retrievedFlight.getFlightNumber());

        Flight flightByName = flightDao.findByName("LC123");
        assertEquals("LC123", flightByName.getFlightNumber());

        List<Flight> flights = flightDao.findAll();
        assertEquals(1, flights.size());

        retrievedFlight.setFlightNumber("LC456");
        flightDao.update(retrievedFlight);
        Flight updatedFlight = flightDao.findByName("LC456");
        assertEquals("LC456", updatedFlight.getFlightNumber());

        TicketDao ticketDao = factory.getTicketDao();

        Ticket ticket = new Ticket();
        ticket.setFlight(updatedFlight);
        ticket.setClient(ivanClient);
        ticket.setWithLuggage(true);
        ticket.setPriorityBoarding(false);
        ticket.setPrice(149.99);

        ticketDao.save(ticket);

        List<Ticket> tickets = ticketDao.findAll();
        assertEquals(1, tickets.size());

        Ticket ticketById = ticketDao.findById(1L);
        assertEquals(ivanClient, ticketById.getClient());

        ticketById.setPriorityBoarding(true);
        ticketDao.update(ticketById);

        Ticket updatedTicket = ticketDao.findById(1L);
        assertTrue(updatedTicket.isPriorityBoarding());

        ticketDao.delete(updatedTicket);
        assertEquals(0, ticketDao.findAll().size());
    }
}
