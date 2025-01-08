public class ClothingApp {
  public static void main(String[] args) {
    var hoodie = new Hoodie(new ChildSize());
    hoodie.getType();
    hoodie.getSize().get();

    var shirt = new Shirt(new AdultSize());
    shirt.getType();
    shirt.getSize().get();
  }
}

interface ClothingItem {

  void getType();
  Size getSize();
}

class Shirt implements ClothingItem {
  
  private final Size size;

  public Shirt(Size size) {
    this.size = size;
  }

  @Override
  public void getType() {
    System.out.println("Shirt");
  }

  @Override
  public Size getSize() {
    return size;
  }
}

class Hoodie implements ClothingItem {

  private final Size size;

  public Hoodie(Size size) {
    this.size = size;
  }

  @Override
  public void getType() {
    System.out.println("Hoodie");
  }

  @Override
  public Size getSize() {
    return size;
  }
}

interface Size {
  void get();
}

class AdultSize implements Size {

  @Override
  public void get() {
    System.out.println("Adult");
  }
}

class ChildSize implements Size {

  @Override
  public void get() {
    System.out.println("Child");
  }
}
