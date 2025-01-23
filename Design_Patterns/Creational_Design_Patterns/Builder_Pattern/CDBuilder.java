
import java.util.ArrayList;
import java.util.List;

public class CDBuilder {
  public static void main(String[] args) {
    
    CDTypeBuilder cdBuilder = new CDTypeBuilder();
    CDType cdType1 = cdBuilder.buildSonyCD();
    cdType1.showItems();

    CDType cdType2 = cdBuilder.buildSamsungCD();
    cdType2.showItems();
  }
}

interface Packing {
  public String pack();
  public int price();
}

abstract class CD implements Packing {
  public abstract String pack();
}

abstract class Company extends CD {
  public abstract int price();
}

class Sony extends Company {

  @Override
  public String pack(){
    return "Sony CD";
  }

  @Override
  public int price() {
    return 20;
  }
}

class Samsung extends Company {

  @Override
  public String pack() {
    return "Samsung CD";
  }

  @Override
  public int price() {
    return 15;
  }
}

class CDType {
  
  private List<Packing> items = new ArrayList<Packing>();

  public void addItem(Packing packs) {
    items.add(packs);
  }

  public void getCost() {
    for (Packing packs: items) {
      packs.price();
    }
  }

  public void showItems() {
    for (Packing packing : items) {
      System.out.println("CD name : "+packing.pack());
      System.out.println("CD price "+packing.price());
    }
  }
}

class CDTypeBuilder {
  
  public CDType buildSonyCD() {
    CDType cds = new CDType();
    cds.addItem(new Sony());
    return cds;
  }

  public CDType buildSamsungCD() {
    CDType cds = new CDType();
    cds.addItem(new Samsung());
    return cds;
  }
}