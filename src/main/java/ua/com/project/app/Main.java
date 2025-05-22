package ua.com.project.app;

import ua.com.project.model.*;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        Flight flight = new Flight("LC123", LocalDate.now().plusDays(5), 100, 50.0);
        Flight longFlight = new Flight("BV248", LocalDate.now().plusDays(100), 45, 530.66);

        Client client1 = new Client("Іван Іванов", "ivan@example.com");
        BaseTicket ticket1 = flight.bookTicket(client1, true, true);

        if (ticket1 != null) {
            System.out.println("Квиток придбано: " + ticket1);
        } else {
            System.out.println("Немає вільних місць.");
        }

        Ticket ticketLuggagePriority = new BaseTicket(client1, flight, false, false);
        ticketLuggagePriority = new Luggage(ticketLuggagePriority);
        ticketLuggagePriority = new PriorityBoarding(ticketLuggagePriority);

        Ticket ticketNoLuggage = new BaseTicket(client1, flight, false, false);

        System.out.println("\n---ticketLuggagePriority---\n" + "Опис: " + ticketLuggagePriority.getDescription());
        System.out.println("Загальна ціна: " + ticketLuggagePriority.getTicketPrice());

        System.out.println("\n---ticketNoLuggage---\n" + "Опис: " + ticketNoLuggage.getDescription());
        System.out.println("Загальна ціна: " + ticketNoLuggage.getTicketPrice());

        BaseTicket longTicket = longFlight.bookTicket(client1, true, false);
        System.out.println("\nКвиток придбано: " + longTicket);
    }
}
