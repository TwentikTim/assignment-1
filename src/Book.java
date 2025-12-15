import java.time.Year;

public class Book {

    private int id;
    private static int idGen = 0;
    private String title;
    private String author;
    private int year;
    private boolean available;


    public Book() {
        this.id = idGen++;
        this.available = true;
    }


    public Book(String title, String author, int year) {
        this();
        setTitle(title);
        setAuthor(author);
        setYear(year);
    }


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public boolean isAvailable() {
        return available;
    }


    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        this.title = title;
    }

    public void setAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Author cannot be empty");
        }
        this.author = author;
    }

    public void setYear(int year) {
        int currentYear = Year.now().getValue();
        if (year < 1500 || year > currentYear) {
            throw new IllegalArgumentException("Invalid year");
        }
        this.year = year;
    }

    // Behavior
    public void markAsBorrowed() {
        available = false;
    }

    public void markAsReturned() {
        available = true;
    }

    @Override
    public String toString() {
        return "Book{id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", available=" + available + "}";
    }
}
