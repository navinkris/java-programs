import java.util.List;

public class OrderTracker {
  
  public static void main(String[] args) {
    PizzaFlavor hawaiian = new PizzaFlavor("Hawaiian");
    Pizza hawaiianPizza1 = new Pizza(4, hawaiian);
    Pizza hawaiianPizza2 = hawaiianPizza1.clone();
    Pizza hawaiianPizza3 = hawaiianPizza1.clone();
    Pizza hawaiianPizza4 = hawaiianPizza1.clone();
    Pizza hawaiianPizza5 = hawaiianPizza1.clone();
    hawaiian.setName("Hawaiian with extra cheese");

    PizzaFlavor pepperoni = new PizzaFlavor("Pepperoni");
    Pizza pepperoniPizza1 = new Pizza(5, pepperoni);
    Pizza pepperoniPizza2 = pepperoniPizza1.clone();
    Pizza pepperoniPizza3 = pepperoniPizza1.clone();
    Pizza pepperoniPizza4 = pepperoniPizza1.clone();
    Pizza pepperoniPizza5 = pepperoniPizza1.clone();

    List<Meal> order = List.of(hawaiianPizza1, hawaiianPizza2, hawaiianPizza3, hawaiianPizza4, hawaiianPizza5,
                              pepperoniPizza1, pepperoniPizza2, pepperoniPizza3, pepperoniPizza4, pepperoniPizza5);

    placeOrder(order);
  }
  
  private static void placeOrder(List<Meal> meals) {
    System.out.println("Order placed: ");
    meals.forEach(System.out::println);
  }
}

abstract class Meal {
  
  private int price;

  public Meal(int price) {
    this.price = price;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int Price) {
    this.price = price;
  }

  public abstract Meal clone();
  
}

class PizzaFlavor {
  
  private String name;

  public PizzaFlavor(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

    @Override
    public String toString() {
        return name;
    }

  
}


class Pizza extends Meal {

  private PizzaFlavor flavor;

  public Pizza(int price, PizzaFlavor flavor) {
    super(price);
    this.flavor = flavor;
  }

  public PizzaFlavor getFlavor() {
    return flavor;
  }

  public void setFlavor(PizzaFlavor flavor) {
    this.flavor = flavor;
  }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pizza{");
        sb.append("flavor=").append(flavor);
        sb.append('}');
        return sb.toString();
    }
  
    @Override
    public Pizza clone() {
      return new Pizza(this.getPrice(), new PizzaFlavor(this.getFlavor().getName()));
    }

}
