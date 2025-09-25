import java.util.Objects;

/**
 * Represents a single book in the library.
 * This class uses encapsulation to hold book data.
 */
public class Book {
    // Private fields to encapsulate the book's data
    private final String isbn;
    private final String title;
    private final String author;
    private boolean isAvailable;

    /**
     * Constructs a new Book object.
     *
     * @param isbn   The International Standard Book Number.
     * @param title  The title of the book.
     * @param author The author of the book.
     */
    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.isAvailable = true; // A new book is always available by default
    }

    // --- Getters ---
    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // --- Setter ---
    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    /**
     * Provides a user-friendly string representation of the Book object.
     *
     * @return A formatted string with book details.
     */
    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }

    /**
     * Overriding equals to identify books by their unique ISBN.
     * This is crucial for searching and removing books from lists.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn);
    }

    /**
     * Overriding hashCode to be consistent with the equals method.
     */
    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}
