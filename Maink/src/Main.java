import models.*;
import services.LibraryService;
import utils.ConsoleUtils;
import java.util.List;

public class Main {
    private static LibraryService library = new LibraryService();

    public static void main(String[] args) {
        initializeSampleData();

        while (true) {
            ConsoleUtils.displayMenu();
            int choice = ConsoleUtils.getIntInput("Enter your choice: ");

            switch (choice) {
                case 1: addBook(); break;
                case 2: addBorrower(); break;
                case 3: borrowBook(); break;
                case 4: returnBook(); break;
                case 5: searchBooks(); break;
                case 6: displayAllBooks(); break;
                case 7: displayAllBorrowers(); break;
                case 8: displayBorrowRecords(); break;
                case 0:
                    System.out.println("Exiting system...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            ConsoleUtils.pressToContinue();
        }
    }

    private static void initializeSampleData() {
        library.addBook(new PaperBook("Java Programming", "John Doe", "1111111111", 500));
        library.addBook(new EBook("Python Basics", "Jane Smith", "2222222222", "PDF"));
        library.addBorrower(new Borrower("S1001", "Alice Johnson"));
        library.addBorrower(new Borrower("S1002", "Bob Williams"));
    }

    private static void addBook() {
        System.out.println("\n=== Add New Book ===");
        String title = ConsoleUtils.getStringInput("Enter title: ");
        String author = ConsoleUtils.getStringInput("Enter author: ");
        String isbn = ConsoleUtils.getStringInput("Enter ISBN: ");

        int type = ConsoleUtils.getIntInput("Book type (1. Paper, 2. E-Book): ");
        if (type == 1) {
            int pages = ConsoleUtils.getIntInput("Enter page count: ");
            library.addBook(new PaperBook(title, author, isbn, pages));
        } else {
            String format = ConsoleUtils.getStringInput("Enter file format: ");
            library.addBook(new EBook(title, author, isbn, format));
        }
        System.out.println("Book added successfully!");
    }

    private static void addBorrower() {
        System.out.println("\n=== Add New Borrower ===");
        String id = ConsoleUtils.getStringInput("Enter borrower ID: ");
        String name = ConsoleUtils.getStringInput("Enter borrower name: ");

        library.addBorrower(new Borrower(id, name));
        System.out.println("Borrower added successfully!");
    }

    private static void borrowBook() {
        System.out.println("\n=== Borrow a Book ===");
        String isbn = ConsoleUtils.getStringInput("Enter book ISBN: ");
        String borrowerId = ConsoleUtils.getStringInput("Enter borrower ID: ");

        BorrowRecord record = library.borrowBook(isbn, borrowerId);
        if (record != null) {
            System.out.println("Book borrowed successfully: " + record);
        } else {
            System.out.println("Failed to borrow book. Check availability or borrower ID.");
        }
    }

    private static void returnBook() {
        System.out.println("\n=== Return a Book ===");
        String isbn = ConsoleUtils.getStringInput("Enter book ISBN to return: ");

        // Find the active borrow record
        for (BorrowRecord record : library.getAllBorrowRecords()) {
            if (record.getBook().getIsbn().equals(isbn) && record.getReturnDate() == null) {
                record.markReturned();
                System.out.println("Book returned successfully: " + record.getBook().getTitle());
                return;
            }
        }
        System.out.println("No active borrowing record found for this ISBN.");
    }

    private static void searchBooks() {
        System.out.println("\n=== Search Books ===");
        System.out.println("1. By Title");
        System.out.println("2. By Author");
        System.out.println("3. By ISBN");
        int searchType = ConsoleUtils.getIntInput("Choose search type: ");

        String query = ConsoleUtils.getStringInput("Enter search term: ");
        List<Book> results;

        switch (searchType) {
            case 1: results = library.searchByTitle(query); break;
            case 2: results = library.searchByAuthor(query); break;
            case 3: results = library.searchByIsbn(query); break;
            default:
                System.out.println("Invalid search type.");
                return;
        }

        ConsoleUtils.displayList("Search Results", results);
    }

    private static void displayAllBooks() {
        ConsoleUtils.displayList("All Books", library.getAllBooks());
    }

    private static void displayAllBorrowers() {
        ConsoleUtils.displayList("All Borrowers", library.getAllBorrowers());
    }

    private static void displayBorrowRecords() {
        ConsoleUtils.displayList("Borrow Records", library.getAllBorrowRecords());
    }
}