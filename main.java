import java.util.Scanner;

/**
 * Main class to run the Library Management System.
 * Provides a command-line interface for user interaction.
 */
public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        // Add some initial data
        library.addBook(new Book("978-0321765723", "The C++ Programming Language", "Bjarne Stroustrup"));
        library.addBook(new Book("978-0132350884", "Clean Code", "Robert C. Martin"));
        library.addBook(new Book("978-0201633610", "Design Patterns", "Erich Gamma"));
        library.addUser(new User("U001", "Alice"));
        library.addUser(new User("U002", "Bob"));

        int choice;
        do {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add a new Book");
            System.out.println("2. Add a new User");
            System.out.println("3. Check out a Book");
            System.out.println("4. Return a Book");
            System.out.println("5. Display all Books");
            System.out.println("6. Display all Users");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Invalid input. Please enter a number.");
                choice = -1; // Set to a non-zero value to continue loop
            }


            switch (choice) {
                case 1:
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(isbn, title, author));
                    break;
                case 2:
                    System.out.print("Enter User ID: ");
                    String userId = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    library.addUser(new User(userId, name));
                    break;
                case 3:
                    System.out.print("Enter User ID: ");
                    String checkoutUserId = scanner.nextLine();
                    System.out.print("Enter Book ISBN to check out: ");
                    String checkoutIsbn = scanner.nextLine();
                    library.checkOutBook(checkoutUserId, checkoutIsbn);
                    break;
                case 4:
                    System.out.print("Enter User ID: ");
                    String returnUserId = scanner.nextLine();
                    System.out.print("Enter Book ISBN to return: ");
                    String returnIsbn = scanner.nextLine();
                    library.returnBook(returnUserId, returnIsbn);
                    break;
                case 5:
                    library.displayAllBooks();
                    break;
                case 6:
                    library.displayAllUsers();
                    break;
                case 0:
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }
}
