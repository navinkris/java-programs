public class PizzaRecipe {
  public static void main(String[] args) {
    
    var vegPizza = new VegPizza();
    vegPizza.makeBase();
    vegPizza.addToppings();
    vegPizza.cook();

    var meatPizza = new MeatFeastPizza();
    meatPizza.makeBase();
    meatPizza.addToppings();
    meatPizza.cook();
  }
}

abstract class Pizza {
  
  public void makeBase() {
    System.out.println("Making base of pizza");
  }

  public abstract void addToppings();

  public void cook() {
    System.out.println("Cooking pizza");
  }
}

class VegPizza extends Pizza {

  @Override
  public void addToppings() {
    System.out.println("Adding veggies as toppings");
  }
}


class MeatFeastPizza extends Pizza {

  @Override
  public void addToppings() {
    System.out.println("Adding meat as toppings");
  }
}