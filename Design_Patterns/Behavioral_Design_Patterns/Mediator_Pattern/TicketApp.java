import java.util.ArrayList;
import java.util.List;

public class TicketApp {

  public static void main(String[] args) {
      
    var board = new Board();
    var ticket = new Ticket();
    var assignee = new Assignee();

    var mediator = new Mediator(ticket, assignee, board);
    mediator.pickUpTicket();
    System.out.println();
    mediator.resolveTicket();
  }
}

class Assignee {
  
  private List<Ticket> tickets = new ArrayList<>();
  
  public List<Ticket> getTickets() {
    return this.tickets;
  }

  public void pickUpTicket(Ticket ticket) {
    System.out.println("Ticket picked up by assignee");
    tickets.add(ticket);
  }

  public void resolveTicket(Ticket ticket) {
    tickets.remove(ticket);
    System.out.println("Ticket resolved");
  }

}

class Ticket {
  
  private Assignee assignee;
  
  public enum Status {
    SUBMITTED,
    IN_PROGRESS,
    DONE
  }
  
  private Status status;

  public Ticket() {
    this.status = Status.SUBMITTED;
  }

  public Status getStatus() {
    return this.status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public void setAssignee(Assignee assignee) {
    this.assignee = assignee;
  }
}

class Board {
  private List<Ticket> inProgressTickets = new ArrayList<>();
  private List<Ticket> doneTickets = new ArrayList<>();

  public List<Ticket> getDoneTickets() {
    return this.doneTickets;
  }

  public void addTicketToInProgressTickets(Ticket ticket) {
    inProgressTickets.add(ticket);
    System.out.println("Ticket added to inProgressTickets");
  }

  public void addTicketToDoneTickets(Ticket ticket) {
    doneTickets.add(ticket);
    System.out.println("Ticket added to doneTickets");
    inProgressTickets.remove(ticket);
    System.out.println("Ticket removed from inProgressTickets");
  }
}

class Mediator {

  private Ticket ticket;
  private Assignee assignee;
  private Board board;

  public Mediator(Ticket ticket, Assignee assignee, Board board) {
    this.ticket = ticket;
    this.assignee = assignee;
    this.board = board;
  }

  public void pickUpTicket() {
    assignee.pickUpTicket(ticket);
    ticket.setAssignee(assignee);
    ticket.setStatus(Ticket.Status.IN_PROGRESS);
    board.addTicketToInProgressTickets(ticket);
  }

  public void resolveTicket() {
    assignee.resolveTicket(ticket);
    ticket.setStatus(Ticket.Status.DONE);
    board.addTicketToDoneTickets(ticket);
  }
}