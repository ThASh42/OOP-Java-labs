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
