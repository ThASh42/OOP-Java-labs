package ua.com.project.model;

import ua.com.project.decorator.TicketDecorator;

public class Luggage extends TicketDecorator {
    public Luggage(Ticket ticket) {
        super(ticket);
    }

    @Override
    public String getDescription() {
        return decoratedTicket.getDescription() + " + Luggage";
    }

    @Override
    public double getTicketPrice() {
        return decoratedTicket.getTicketPrice() + 40;
    }
}
