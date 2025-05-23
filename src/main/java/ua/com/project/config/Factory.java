package ua.com.project.config;

import org.hibernate.SessionFactory;
import ua.com.project.dao.ClientDao;
import ua.com.project.dao.FlightDao;
import ua.com.project.dao.TicketDao;
import ua.com.project.dao.UsersDao;
import ua.com.project.repository.ClientRepository;
import ua.com.project.repository.FlightRepository;
import ua.com.project.repository.TicketRepository;
import ua.com.project.repository.UserRepository;

import javax.persistence.Persistence;

public class Factory {

    public static final Factory INSTANCE = new Factory();

    public static Factory getInstance() {
        return INSTANCE;
    }

    private final SessionFactory session;

    public Factory() {
        this.session = (SessionFactory) Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
    }

    public UsersDao getUserDao() {
        return new UserRepository(session);
    }

    public ClientDao getClientDao() {
        return new ClientRepository(session);
    }

    public FlightDao getFlightDao() {
        return new FlightRepository(session);
    }

    public TicketDao getTicketDao() {
        return new TicketRepository(session);
    }
}
