package ua.com.project.model;

import ua.com.project.decorator.TicketDecorator;

public class PriorityBoarding extends TicketDecorator {
    public PriorityBoarding(Ticket ticket) {
        super(ticket);
    }

    @Override
    public String getDescription() {
        return decoratedTicket.getDescription() + " + пріоритетна посадка";
    }

    @Override
    public double getTicketPrice() {
        return decoratedTicket.getTicketPrice() + 15;
    }
}
