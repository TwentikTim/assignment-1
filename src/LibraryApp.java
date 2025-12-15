import java.util.ArrayList;
import java.util.Scanner;

public class LibraryApp {

    private ArrayList<Book> books = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    
    public void run() {
        boolean running = true;

        while (running) {
            System.out.println("\nWelcome to Library App!");
            System.out.println("1. Print all books");
            System.out.println("2. Add new book");
            System.out.println("3. Search books by title");
            System.out.println("4. Borrow a book");
            System.out.println("5. Return a book");
            System.out.println("6. Delete a book by id");
            System.out.println("7. Quit");
            System.out.print("Choose an option: ");

            int choice = getValidatedChoice();

            switch (choice) {
                case 1 -> printBooks();
                case 2 -> addBook();
                case 3 -> searchBook();
                case 4 -> borrowBook();
                case 5 -> returnBook();
                case 6 -> deleteBook();
                case 7 -> running = false;
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    
    private int getValidatedChoice() {
        int choice = -1;
        while (choice < 1 || choice > 7) {
            try {
                choice = scanner.nextInt();
                scanner.nextLine();  // clear buffer
                if (choice < 1 || choice > 7) {
                    System.out.println("Please choose a valid option (1-7).");
                }
            } catch (Exception e) {
                System.out.println("Invalid input, please enter a number between 1 and 7.");
                scanner.nextLine();  
            }
        }
        return choice;
    }

    
    private void printBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library");
            return;
        }
        for (Book book : books) {
            System.out.println(book);
        }
    }

    
    private void addBook() {
        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("Author: ");
        String author = scanner.nextLine();

        int year = getValidatedYear();

        Book book = new Book(title, author, year);
        books.add(book);

        System.out.println("Book added");
    }

    
    private int getValidatedYear() {
        int year = 0;
        boolean validYear = false;
        while (!validYear) {
            try {
                System.out.print("Year: ");
                year = scanner.nextInt();
                scanner.nextLine(); 
                if (year < 1500 || year > 2023) {
                    System.out.println("Please enter a valid year between 1500 and 2023.");
                } else {
                    validYear = true;
                }
            } catch (Exception e) {
                System.out.println("Invalid input, please enter a valid year.");
                scanner.nextLine();  
            }
        }
        return year;
    }

    
    private void searchBook() {
        System.out.print("Enter part of title: ");
        String text = scanner.nextLine().toLowerCase();

        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(text)) {
                System.out.println(book);
            }
        }
    }

    
    private void borrowBook() {
        System.out.print("Enter book id: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        boolean found = false;
        for (Book book : books) {
            if (book.getId() == id) {
                if (book.isAvailable()) {
                    book.markAsBorrowed();
                    System.out.println("Book borrowed");
                } else {
                    System.out.println("Book already borrowed");
                }
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Book not found.");
        }
    }

    
    private void returnBook() {
        System.out.print("Enter book id: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        boolean found = false;
        for (Book book : books) {
            if (book.getId() == id) {
                if (!book.isAvailable()) {
                    book.markAsReturned();
                    System.out.println("Book returned");
                } else {
                    System.out.println("Book was not borrowed");
                }
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Book not found.");
        }
    }

    
    private void deleteBook() {
        System.out.print("Enter book id: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        boolean removed = false;
        for (Book book : books) {
            if (book.getId() == id) {
                books.remove(book);
                System.out.println("Book deleted");
                removed = true;
                break;
            }
        }

        if (!removed) {
            System.out.println("Book not found.");
        }
    }

    
    public static void main(String[] args) {
        new LibraryApp().run();
    }
}
