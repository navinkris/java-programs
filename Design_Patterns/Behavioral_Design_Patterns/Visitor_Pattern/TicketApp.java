import java.util.ArrayList;
import java.util.List;

public class TicketApp {

  public static void main(String[] args) {
    var groupTicket = new GroupTicket();
    var ticket1 = new AdultTicket();
    var ticket2 = new AdultTicket();
    groupTicket.addElement(ticket1);
    groupTicket.addElement(ticket2);

    System.out.println("Price: " + groupTicket.getPrice());

    var discountVisitor = new DiscountVisitor();
    groupTicket.accept(discountVisitor);

    System.out.println("Price: " + groupTicket.getPrice());
  }
  
}

interface TicketElement {

  int getPrice();

  void accept(Visitor visitor);
}

class AdultTicket implements TicketElement {

  private int price = 10;

  @Override
  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}

class GroupTicket implements TicketElement {

  private final List<TicketElement> elements = new ArrayList<>();

  @Override
  public int getPrice() {
    return elements.stream().mapToInt(TicketElement::getPrice).sum();
  }

  public void addElement(TicketElement element) {
    elements.add(element);
  }

  public List<TicketElement> getElements() {
    return elements;
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}

interface Visitor {

  void visit(AdultTicket ticket);
  void visit(GroupTicket ticket);
}

class DiscountVisitor implements Visitor {

  public void visit(AdultTicket ticket) {
      ticket.setPrice(5);
  }

  public void visit(GroupTicket ticket) {
      ticket.getElements().forEach(element -> element.accept(this));
  }

}