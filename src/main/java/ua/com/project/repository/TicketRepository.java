package ua.com.project.repository;

import org.hibernate.SessionFactory;
import ua.com.project.dao.TicketDao;
import ua.com.project.entity.Ticket;

import javax.persistence.EntityManager;
import java.util.List;

public class TicketRepository implements TicketDao {

    private final SessionFactory sessionFactory;

    public TicketRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Ticket ticket) {
        EntityManager em = sessionFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(ticket);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(Ticket ticket) {
        EntityManager em = sessionFactory.createEntityManager();
        em.getTransaction().begin();
        em.merge(ticket);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Ticket ticket) {
        EntityManager em = sessionFactory.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("delete from Ticket t where t.id=:id")
                .setParameter("id", ticket.getId())
                .executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void deleteAll() {
        EntityManager em = sessionFactory.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("delete from Ticket").executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Ticket> findAll() {
        EntityManager em = sessionFactory.createEntityManager();
        em.getTransaction().begin();
        List<Ticket> tickets = em.createQuery("select t from Ticket t", Ticket.class).getResultList();
        em.getTransaction().commit();
        em.close();
        return tickets;
    }

    @Override
    public Ticket findById(Long id) {
        EntityManager em = sessionFactory.createEntityManager();
        em.getTransaction().begin();
        Ticket ticket = em.createQuery("select t from Ticket t where t.id=:id", Ticket.class)
                .setParameter("id", id)
                .getSingleResult();
        em.getTransaction().commit();
        em.close();
        return ticket;
    }

    @Override
    public Ticket findByName(String name) {
        throw new UnsupportedOperationException("findByName not supported for Ticket");
    }
}
