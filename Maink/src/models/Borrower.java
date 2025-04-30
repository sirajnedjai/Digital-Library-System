package models;

import java.util.ArrayList;
import java.util.List;

public class Borrower {
    private String id;
    private String name;
    private List<BorrowRecord> borrowedBooks;

    public Borrower(String id, String name) {
        this.id = id;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public List<BorrowRecord> getBorrowedBooks() { return borrowedBooks; }

    public void borrowBook(BorrowRecord record) {
        borrowedBooks.add(record);
    }

    public void returnBook(BorrowRecord record) {
        borrowedBooks.remove(record);
    }

    @Override
    public String toString() {
        return String.format("%s (ID: %s) - Books borrowed: %d",
                name, id, borrowedBooks.size());
    }
}