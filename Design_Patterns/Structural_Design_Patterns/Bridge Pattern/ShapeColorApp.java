public class ShapeColorApp {
  public static void main(String[] args) {
    var circle = new Circle(new Blue());
    circle.getType();
    circle.getColor().get();

    var square = new Square(new Red());
    square.getType();
    square.getColor().get();
  }
}

interface Shape {
  void getType();
  Color getColor();
}

class Circle implements Shape {

  private final Color color;

  public Circle(Color color) {
    this.color = color;
  }

  @Override
  public void getType() {
    System.out.println("Circle");
  }

  @Override
  public Color getColor() {
    return color;
  }
}

class Square implements Shape {

  private final Color color;

  public Square(Color color) {
    this.color = color;
  }

  @Override
  public void getType() {
    System.out.println("Square");
  }

  @Override
  public Color getColor() {
    return color;
  }
}

interface Color {
  void get();
}

class Red implements Color {

  @Override
  public void get() {
    System.out.println("Red");
  }
}

class Blue implements Color {

  @Override
  public void get() {
    System.out.println("Blue");
  }
}