
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class TicketOffice {
  
  private static final TicketMachine ticketMachine = new TicketMachine();

  public static void main(String[] args) {
    buyATicket("Bus");
    buyATicket("Train");
  }

  private static void buyATicket(String ticketType) {
    var ticket = ticketMachine.createTicket(ticketType);
    System.out.println("One "+ticketType+" purchased. The price is $" + ticket.getPrice());
  }
}

class TicketMachine {
  
  private static final Map<String, Supplier<Ticket>> ticketMap = new HashMap();
  
  static {
    ticketMap.put("Bus", BusTicket::new);
    ticketMap.put("Train", TrainTicket::new);
  }
  
  Ticket createTicket(String ticketType) {
    if(ticketMap.get(ticketType) != null) {
      return ticketMap.get(ticketType).get();
    } else {
      throw new IllegalArgumentException("Invalid ticket type");
    }
  }
}

interface Ticket {
  int getPrice();
}


class BusTicket implements Ticket{
  
  @Override
  public int getPrice() {
    return 3;
  }
}

class TrainTicket implements Ticket{

  @Override
  public int getPrice() {
    return 7;
  }
}
