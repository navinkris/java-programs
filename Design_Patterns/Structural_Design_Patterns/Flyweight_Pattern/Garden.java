
import java.util.HashMap;
import java.util.Map;

public class Garden {
  public static void main(String[] args) {
      var sunflower1 = FlowerFactory.createFlower("Sunflower");
      var sunflower2 = FlowerFactory.createFlower("Sunflower");
      var sunflower3 = FlowerFactory.createFlower("Sunflower");
      System.out.println(sunflower1);
      System.out.println(sunflower2);
      System.out.println(sunflower3);

      var rose1 = FlowerFactory.createFlower("Rose");
      var rose2 = FlowerFactory.createFlower("Rose");
      var rose3 = FlowerFactory.createFlower("Rose");
      System.out.println(rose1);
      System.out.println(rose2);
      System.out.println(rose3);
  }
}

class Flower {
  
  private String name;

  public Flower(String name) {
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

class FlowerFactory {
  
  private static final Map<String, Flower> flowerCache = new HashMap<>();

  public static Flower createFlower(String name) {
    return flowerCache.computeIfAbsent(name, Flower::new);
  }
}
