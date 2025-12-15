public class Main {
    public static void main(String[] args) {

        Book b1 = new Book("1984", "George Orwell", 1949);
        Book b2 = new Book("The Hobbit", "J.R.R. Tolkien", 1937);

        System.out.println(b1);
        System.out.println(b2);

        b1.markAsBorrowed();
        System.out.println("After borrowing:");
        System.out.println(b1);
    }
}
