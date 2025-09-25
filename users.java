import java.util.ArrayList;
import java.util.List;

/**
 * Represents a library user.
 * This class holds user information and manages their borrowed books.
 */
public class User {
    private final String userId;
    private final String name;
    // Composition: A User 'has a' list of borrowed Books.
    private final List<Book> borrowedBooks;

    /**
     * Constructs a new User object.
     *
     * @param userId A unique identifier for the user.
     * @param name   The name of the user.
     */
    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    // --- Getters ---
    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    /**
     * Adds a book to the user's list of borrowed books.
     *
     * @param book The book to be borrowed.
     */
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    /**
     * Removes a book from the user's list of borrowed books.
     *
     * @param book The book to be returned.
     */
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    /**
     * Provides a user-friendly string representation of the User object,
     * including a list of borrowed books.
     *
     * @return A formatted string with user details.
     */
    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", borrowedBooks=" + borrowedBooks.size() +
                '}';
    }
}
