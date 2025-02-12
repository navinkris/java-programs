// Demonstrating Association, Aggregation, and Composition in Java

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Author class
class Author {
    private String name;

    public Author(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Book class with Aggregation relationship to Author
class Book {
    private String title;
    private List<Author> authors;

    public Book(String title, List<Author> authors) {
        this.title = title;
        this.authors = authors;  // Aggregation: Book has Authors, but Authors can exist independently
    }

    public String getTitle() {
        return title;
    }

    public List<Author> getAuthors() {
        return authors;
    }
}

// Library class with Composition relationship to Book
class Library {
    private String name;
    private List<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);  // Composition: Library owns Books, if Library is deleted, Books are too
    }

    public void displayLibrary() {
        System.out.println("Library: " + name);
        for (Book book : books) {
            System.out.println("  Book: " + book.getTitle());
            System.out.print("    Authors: ");
            for (Author author : book.getAuthors()) {
                System.out.print(author.getName() + " ");
            }
            System.out.println();
        }
    }
}

public class LibrarySystemDemo {
    public static void main(String[] args) {
        // Creating Authors
        Author author1 = new Author("J.K. Rowling");
        Author author2 = new Author("J.R.R. Tolkien");
        Author author3 = new Author("George R.R. Martin");

        // Creating Books (Aggregation with Authors)
        Book book1 = new Book("Harry Potter", Arrays.asList(author1));
        Book book2 = new Book("The Lord of the Rings", Arrays.asList(author2));
        Book book3 = new Book("A Song of Ice and Fire", Arrays.asList(author3));

        // Creating Library (Composition with Books)
        Library library = new Library("City Library");
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Display Library Details
        library.displayLibrary();
    }
}
