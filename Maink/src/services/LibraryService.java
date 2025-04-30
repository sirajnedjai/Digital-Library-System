package services;

import models.*;
import java.util.ArrayList;
import java.util.List;

public class LibraryService implements Searchable {
    private List<Book> books;
    private List<Borrower> borrowers;
    private List<BorrowRecord> borrowRecords;

    public LibraryService() {
        this.books = new ArrayList<>();
        this.borrowers = new ArrayList<>();
        this.borrowRecords = new ArrayList<>();
    }

    // Book management methods
    public void addBook(Book book) {
        books.add(book);
    }

    // Borrower management methods
    public void addBorrower(Borrower borrower) {
        borrowers.add(borrower);
    }

    // Borrowing process methods
    public BorrowRecord borrowBook(String isbn, String borrowerId) {
        Book book = findBookByIsbn(isbn);
        Borrower borrower = findBorrowerById(borrowerId);

        if (book != null && borrower != null && !book.isBorrowed()) {
            BorrowRecord record = new BorrowRecord(book, borrower);
            borrowRecords.add(record);
            borrower.borrowBook(record);
            return record;
        }
        return null;
    }

    // Implement all Searchable interface methods
    @Override
    public List<Book> searchByTitle(String title) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                results.add(book);
            }
        }
        return results;
    }

    @Override
    public List<Book> searchByAuthor(String author) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                results.add(book);
            }
        }
        return results;
    }

    @Override
    public List<Book> searchByIsbn(String isbn) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                results.add(book);
            }
        }
        return results;
    }

    // Helper methods
    private Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    private Borrower findBorrowerById(String id) {
        for (Borrower borrower : borrowers) {
            if (borrower.getId().equals(id)) {
                return borrower;
            }
        }
        return null;
    }

    // Getters for collections
    public List<Book> getAllBooks() { return books; }
    public List<Borrower> getAllBorrowers() { return borrowers; }
    public List<BorrowRecord> getAllBorrowRecords() { return borrowRecords; }
}