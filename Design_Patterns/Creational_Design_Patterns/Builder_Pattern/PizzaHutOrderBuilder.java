
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PizzaHutOrderBuilder {
  public static void main(String[] args) throws IOException {
    OrderBuilder builder = new OrderBuilder();

    OrderedItems orderedItems = builder.preparePizza();

    orderedItems.showItems();

    System.out.println("\n");
    System.out.println("Total Cost: "+orderedItems.getCost());
  }
}

interface Item {
  
  public String getName();
  public String getSize();
  public float getPrice();

}

abstract class Pizza implements Item {

  public abstract float getPrice();

}

abstract class VegPizza extends Pizza {
  
  @Override
  public abstract String getName();

  @Override
  public abstract String getSize();

  @Override
  public abstract float getPrice();

}

class SmallCheesePizza extends Pizza {

  @Override
  public String getName() {
    return "Cheese Pizza";
  }

  @Override
  public String getSize() {
    return "Small";
  }

  @Override
  public float getPrice() {
    return 170.0f;
  }
}

class MediumCheesePizza extends Pizza {

  @Override
  public String getName() {
    return "Cheese Pizza";
  }

  @Override
  public String getSize() {
    return "Medium";
  }

  @Override
  public float getPrice() {
    return 240.0f;
  }
}

class LargeCheesePizza extends Pizza {

  @Override
  public String getName() {
    return "Cheese Pizza";
  }

  @Override
  public String getSize() {
    return "Large";
  }

  @Override
  public float getPrice() {
    return 300.0f;
  }
}

class ExtraLargeCheesePizza extends Pizza {

  @Override
  public String getName() {
    return "Cheese Pizza";
  }

  @Override
  public String getSize() {
    return "Extra Large";
  }

  @Override
  public float getPrice() {
    return 370.0f;
  }
}

class OnionPizza extends VegPizza {

    @Override
    public String getName() {
      return "Onion Pizza";
    }

    @Override
    public String getSize() {
      return "Regular";
    }

    @Override
    public float getPrice() {
      return 210.0f;
    }
}

class MasalaPizza extends VegPizza {

  @Override
  public String getName() {
    return "Masala Pizza";
  }

  @Override
  public String getSize() {
    return "Regular";
  }

  @Override
  public float getPrice() {
    return 270.0f;
  }
}

class NonVegPizza extends Pizza {

    @Override
    public float getPrice() {
      return 300.0f;
    }

    @Override
    public String getName() {
      return "Non-veg Pizza";
    }

    @Override
    public String getSize() {
      return "Regular";
    }
}

abstract class CoolDrink implements Item {
  
  public abstract float getPrice();
}

abstract class Pepsi extends CoolDrink {

  @Override
  public abstract String getName();

  @Override
  public abstract String getSize();

  @Override
  public abstract float getPrice();

}

abstract class Coke extends CoolDrink {

  @Override
  public abstract String getName();

  @Override
  public abstract String getSize();

  @Override
  public abstract float getPrice();

}

class SmallPepsi extends Pepsi {

  @Override
  public String getName() {
    return "300ml Pepsi";
  }

  @Override
  public String getSize() {
    return "Small";
  }

  @Override
  public float getPrice() {
    return 50.0f;
  }
}

class MediumPepsi extends Pepsi {

  @Override
  public String getName() {
    return "500ml Pepsi";
  }

  @Override
  public String getSize() {
    return "Medium";
  }

  @Override
  public float getPrice() {
    return 75.0f;
  }
}

class LargePepsi extends Pepsi {

  @Override
  public String getName() {
    return "750ml Pepsi";
  }

  @Override
  public String getSize() {
    return "Large";
  }

  @Override
  public float getPrice() {
    return 100.0f;
  }
}

class RegularCoke extends Coke {

  @Override
  public String getName() {
    return "500ml Pepsi";
  }

  @Override
  public String getSize() {
    return "Regular";
  }

  @Override
  public float getPrice() {
    return 80.0f;
  }
}

class OrderedItems {

  List<Item> items = new ArrayList<Item>();

  public void addItems(Item item) {
    items.add(item);
  }

  public float getCost() {
    float cost = 0.0f;
    for(Item item: items) {
      cost+=item.getPrice();
    }
    return cost;
  }

  public void showItems() {

    for(Item item: items) {
      System.out.println("Item is: "+item.getName());
      System.out.println("Size is: "+item.getSize());
      System.out.println("Price is: "+item.getPrice());
    }
  }
}

class OrderBuilder {
  public OrderedItems preparePizza() throws IOException {

    OrderedItems itemsOrder = new OrderedItems();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    System.out.println("Enter the choice of Pizza ");
    System.out.println("================================");
    System.out.println("      1. Veg-Pizza       ");
    System.out.println("      2. Non-Veg Pizza        ");
    System.out.println("      3. Exit         ");

    int pizzaAndColdDrinkChoice = Integer.parseInt(br.readLine());
    switch(pizzaAndColdDrinkChoice) {
      case 1: {
        System.out.println("You ordered Veg Pizza");
        System.out.println("\n\n");
        System.out.println("Entere the types of Veg-Pizza");
        System.out.println("=============================");
        System.out.println("       1.Cheese Pizza        ");
        System.out.println("       2.Onion Pizza         ");
        System.out.println("       3.Masala Pizza        ");
        System.out.println("       4.Exit                ");
        System.out.println("=============================");

        int vegPizzaChoice = Integer.parseInt(br.readLine());

        switch(vegPizzaChoice) {
          case 1: {
            System.out.println("You ordered Cheese Pizza");
            System.out.println("Enter the cheeze pizza size");
            System.out.println("================================");
            System.out.println("    1. Small Cheeze Pizza    ");
            System.out.println("    2. Medium Cheeze Pizza    ");
            System.out.println("    3. Large Cheeze Pizza     ");
            System.out.println("    4. Extra Large Pizza     ");
            System.out.println("================================");
            
            int cheezePizzaSize = Integer.parseInt(br.readLine());

            switch(cheezePizzaSize) {
              case 1:
                itemsOrder.addItems(new SmallCheesePizza());
                break;
              case 2:
                itemsOrder.addItems(new MediumCheesePizza());
                break;
              case 3:
                itemsOrder.addItems(new LargeCheesePizza());
                break;
              case 4:
                itemsOrder.addItems(new ExtraLargeCheesePizza());
                break;
            }
          }
          break;
          case 2: {
            System.out.println("You ordered Onion Pizza");
            System.out.println("========================");
            itemsOrder.addItems(new OnionPizza());
          }
          break;
          case 3: {
            System.out.println("You ordered Masal Pizza");
            System.out.println("========================");
            itemsOrder.addItems(new MasalaPizza());
          }
          break;
        }
        break;
      }

      case 2: {
        System.out.println("You ordered Non-Veg Pizza");
        System.out.println("\n\n");
        itemsOrder.addItems(new NonVegPizza());
        break;
      }
      default: {
        break;
      }
    }

    System.out.println("Enter the choice of Cold Drink");
    System.out.println("==============================");
    System.out.println("           1.Pepsi            ");
    System.out.println("           2.Coke             ");
    System.out.println("           3.Exit             ");

    int coldDrink = Integer.parseInt(br.readLine());

    switch(coldDrink) {
      case 1: {
        System.out.println("You ordered Pepsi");
        System.out.println("Enter the Pepsi Size");
        System.out.println("=====================");
        System.out.println("      1.Small Pepsi        ");
        System.out.println("      2.Medium Pepsi       ");
        System.out.println("      3.Large Pepsi        ");
        System.out.println("=====================");

        int pepsiSize = Integer.parseInt(br.readLine());
        switch(pepsiSize) {
          case 1:
            itemsOrder.addItems(new SmallPepsi());
            break;
          case 2:
            itemsOrder.addItems(new MediumPepsi());
            break;
          case 3:
            itemsOrder.addItems(new LargePepsi());
            break;
        }
      }
      break;
      case 2: 
      {
        System.out.println("You ordered Coke");
        System.out.println("=================");
        itemsOrder.addItems(new RegularCoke());
      }
      break;
      default: {
        break;
      }
    }
    return itemsOrder;
  }
}