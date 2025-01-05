
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class Store {
  
  private static final VendingMachine vendingMachine = new VendingMachine();

  public static void main(String[] args) {
    buyASnack("Drink");
    buyASnack("ChocolateBar");
    buyASnack("Chips");
  }

  private static void buyASnack(String snackType) {
    var snack = vendingMachine.getSnack(snackType);
    System.out.println("One "+snackType+ " purchased. The price is $"+snack.getPrice());
  }
}

class VendingMachine {
  
  private static final Map<String, Supplier<Snack>> snackMap = new HashMap();
  
  static {
    snackMap.put("Chips", Chips::new);
    snackMap.put("ChocolateBar", ChocolateBar::new);
    snackMap.put("Drink", Drink::new);
  }

  Snack getSnack(String snackType) {
    if(snackMap.get(snackType) != null) {
      return snackMap.get(snackType).get();
    }  else {
      throw new IllegalArgumentException("Invalid snack type");
    }
  }
}

interface Snack {
  int getPrice();
}

class Chips implements Snack {

  @Override
  public int getPrice() {
    return 2;
  }
  
}

class ChocolateBar implements Snack {

  @Override
  public int getPrice() {
    return 3;
  }
  
}

class Drink implements Snack {

  @Override
  public int getPrice() {
    return 4;
  }
  
}
