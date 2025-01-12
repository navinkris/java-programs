import java.util.HashMap;
import java.util.Map;

public class Restaurant {
    public static void main(String[] args) {
      var pizza1 = OrderFactory.createOrder("pizza");
      var pizza2 = OrderFactory.createOrder("pizza");
      var pizza3 = OrderFactory.createOrder("pizza");
      System.out.println(pizza1);
      System.out.println(pizza2);
      System.out.println(pizza3);

      var burger1 = OrderFactory.createOrder("burger");
      var burger2 = OrderFactory.createOrder("burger");
      var burger3 = OrderFactory.createOrder("burger");
      System.out.println(burger1);
      System.out.println(burger2);
      System.out.println(burger3);
    }
}

class Order {

  private String name;

  public Order(String name) {
    this.name = name;
    System.out.println("Creating " + name + " object");
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println("Done creating " + name + " object");
  }
}

class OrderFactory {

  private static final Map<String, Order> orderCache = new HashMap<>();

  public static Order createOrder(String name) {
    return orderCache.computeIfAbsent(name, Order::new);
  }
}
