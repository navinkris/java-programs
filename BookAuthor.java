/*
 * 5. Constructor Overloading
  Q5: Create a Book class with fields title, author, and price. 
  Implement constructor overloading to create books with different combinations of data (e.g., with/without price).

  Concepts Tested: Constructor Overloading.
 */

class Book {
  private String title;
  private String author;
  private double price;
  
  public Book(String title) {
    this.title = title;
  }

  public Book(String title, String author) {
    this.title = title;
    this.author = author;
  }

  public Book(String title, String author, double price) {
    this.title = title;
    this.author = author;
    this.price = price;
  }

  public void printBookDetails() {
    System.out.println("Book Details");
    System.out.println("===============");
    System.out.println("Title: "+this.title);
    System.out.println("Author: "+(this.author != null && !this.author.isEmpty() ? this.author : "N/A"));
    System.out.println("Price: "+(this.price > 0 ? this.price : "N/A"));
  }
}


public class BookAuthor {
  public static void main(String[] args) {
    Book b1 = new Book("Harry Potter");
    b1.printBookDetails();
    Book b2 = new Book("Monk who sold his Ferrari", "Robin Sharma", 180.0);
    b2.printBookDetails();
  }
}
