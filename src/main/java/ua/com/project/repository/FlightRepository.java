package ua.com.project.repository;

import org.hibernate.SessionFactory;
import ua.com.project.dao.FlightDao;
import ua.com.project.entity.Flight;

import javax.persistence.EntityManager;
import java.util.List;

public class FlightRepository implements FlightDao {

    private final SessionFactory sessionFactory;

    public FlightRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Flight flight) {
        EntityManager em = sessionFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(flight);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(Flight flight) {
        EntityManager em = sessionFactory.createEntityManager();
        em.getTransaction().begin();
        em.merge(flight);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Flight flight) {
        EntityManager em = sessionFactory.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("delete from Flight f where f.id=:id")
                .setParameter("id", flight.getId())
                .executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void deleteAll() {
        EntityManager em = sessionFactory.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("delete from Flight").executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Flight> findAll() {
        EntityManager em = sessionFactory.createEntityManager();
        em.getTransaction().begin();
        List<Flight> flights = em.createQuery("select f from Flight f", Flight.class).getResultList();
        em.getTransaction().commit();
        em.close();
        return flights;
    }

    @Override
    public Flight findById(Long id) {
        EntityManager em = sessionFactory.createEntityManager();
        em.getTransaction().begin();
        Flight flight = em.createQuery("select f from Flight f where f.id=:id", Flight.class)
                .setParameter("id", id)
                .getSingleResult();
        em.getTransaction().commit();
        em.close();
        return flight;

    }

    @Override
    public Flight findByName(String name) {
        EntityManager em = sessionFactory.createEntityManager();
        em.getTransaction().begin();
        Flight flight = em.createQuery("select f from Flight f where f.flightNumber = :name", Flight.class)
                .setParameter("name", name)
                .getSingleResult();
        em.getTransaction().commit();
        em.close();
        return flight;
    }
}
