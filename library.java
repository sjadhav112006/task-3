import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Manages collections of books and users, and handles library operations.
 * This class abstracts away the complexity of managing the system.
 */
public class Library {
    // Composition: The Library 'has a' list of books and users.
    private final List<Book> books;
    private final List<User> users;

    /**
     * Constructs a new Library object with empty lists for books and users.
     */
    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    // --- Core Library Operations ---

    public void addBook(Book book) {
        books.add(book);
        System.out.println("SUCCESS: Book '" + book.getTitle() + "' added to the library.");
    }

    public void addUser(User user) {
        users.add(user);
        System.out.println("SUCCESS: User '" + user.getName() + "' has been registered.");
    }

    /**
     * Handles the logic for a user checking out a book.
     *
     * @param userId The ID of the user checking out the book.
     * @param isbn   The ISBN of the book to be checked out.
     */
    public void checkOutBook(String userId, String isbn) {
        Optional<Book> bookOpt = findBookByIsbn(isbn);
        Optional<User> userOpt = findUserById(userId);

        if (bookOpt.isEmpty()) {
            System.out.println("ERROR: Book with ISBN " + isbn + " not found.");
            return;
        }
        if (userOpt.isEmpty()) {
            System.out.println("ERROR: User with ID " + userId + " not found.");
            return;
        }

        Book book = bookOpt.get();
        User user = userOpt.get();

        if (!book.isAvailable()) {
            System.out.println("ERROR: Book '" + book.getTitle() + "' is currently not available.");
            return;
        }

        // Proceed with checkout
        book.setAvailable(false);
        user.borrowBook(book);
        System.out.println("SUCCESS: " + user.getName() + " has checked out '" + book.getTitle() + "'.");
    }

    /**
     * Handles the logic for a user returning a book.
     *
     * @param userId The ID of the user returning the book.
     * @param isbn   The ISBN of the book being returned.
     */
    public void returnBook(String userId, String isbn) {
        Optional<Book> bookOpt = findBookByIsbn(isbn);
        Optional<User> userOpt = findUserById(userId);

        if (bookOpt.isEmpty()) {
            System.out.println("ERROR: Book with ISBN " + isbn + " not found.");
            return;
        }
        if (userOpt.isEmpty()) {
            System.out.println("ERROR: User with ID " + userId + " not found.");
            return;
        }

        Book book = bookOpt.get();
        User user = userOpt.get();

        if (!user.getBorrowedBooks().contains(book)) {
            System.out.println("ERROR: " + user.getName() + " has not borrowed this book.");
            return;
        }
        
        // Proceed with return
        book.setAvailable(true);
        user.returnBook(book);
        System.out.println("SUCCESS: " + user.getName() + " has returned '" + book.getTitle() + "'.");
    }


    // --- Helper Methods ---

    public Optional<Book> findBookByIsbn(String isbn) {
        return books.stream()
                .filter(book -> book.getIsbn().equalsIgnoreCase(isbn))
                .findFirst();
    }

    public Optional<User> findUserById(String userId) {
        return users.stream()
                .filter(user -> user.getUserId().equalsIgnoreCase(userId))
                .findFirst();
    }

    // --- Display Methods ---

    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }
        System.out.println("\n--- Library Books ---");
        books.forEach(System.out::println);
        System.out.println("---------------------\n");
    }
    
    public void displayAllUsers() {
        if (users.isEmpty()) {
            System.out.println("No users registered in the library.");
            return;
        }
        System.out.println("\n--- Library Users ---");
        users.forEach(user -> {
            System.out.println(user);
            // Also show the books they've borrowed
            if (!user.getBorrowedBooks().isEmpty()) {
                System.out.println("  Borrowed Books:");
                user.getBorrowedBooks().forEach(book -> System.out.println("    - " + book.getTitle()));
            }
        });
        System.out.println("---------------------\n");
    }
}
