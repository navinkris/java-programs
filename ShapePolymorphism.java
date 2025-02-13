/* 
    2. Polymorphism
    Q2: Create a Shape class with subclasses Circle, Rectangle, and Triangle. Each subclass should implement a calculateArea() method. 
        Write a program to calculate and display the area of different shapes using polymorphism.

    Concepts Tested: Method Overriding, Dynamic Polymorphism.
    
*/

class Shape {
    public void calculateArea() {
        System.out.println("Calculating the area of the Shape");
    }
}

class Circle extends Shape {
    
    private int radius;
    
    public Circle(int radius) {
        this.radius = radius;
    } 
    
    public int getRadius() {
        return this.radius;
    }
    
    public void setRadius(int Radius) {
        this.radius = radius;
    }
    
    @Override
    public void calculateArea() {
        System.out.println("Area of the circle is : "+ (3.14 * radius * radius));
    }
}

class Rectangle extends Shape {
    
    private int length;
    private int breadth;
    
    public Rectangle(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }
    
    public void setLength(int length) {
        this.length = length;
    }
    
    public int getLength() {
        return this.length;
    }
    
    public void setBreadth(int breadth) {
        this.breadth = breadth;
    }
    
    public int getBreadth() {
        return this.breadth;
    }
    
    @Override
    public void calculateArea() {
     System.out.println("Area of the rectangle is : "+(length * breadth));   
    }
}

class Triangle extends Shape {
    
    private int base;
    private int height;
    
    public Triangle(int base, int height) {
        this.base = base;
        this.height = height;
    }
    
    public void setBase(int base) {
        this.base = base;
    }
    
    public int getBase() {
        return this.base;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }
    
    public int getHeight() {
        return this.height;
    }
    
    @Override
    public void calculateArea() {
     System.out.println("Area of the triangle is : "+(0.5 * base * height));   
    }
}

public class ShapePolymorphism {
    public static void main(String[] args) {
        Shape c = new Circle(5);
        Shape r = new Rectangle(4, 3);
        Shape t = new Triangle(4, 5);
        c.calculateArea();
        r.calculateArea();
        t.calculateArea();
    }
}
