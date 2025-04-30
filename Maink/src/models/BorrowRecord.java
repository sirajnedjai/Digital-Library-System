package models;

import java.time.LocalDate;

public class BorrowRecord {
    private Book book;
    private Borrower borrower;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    public BorrowRecord(Book book, Borrower borrower) {
        this.book = book;
        this.borrower = borrower;
        this.borrowDate = LocalDate.now();
        this.returnDate = null;
        book.setBorrowed(true);
    }

    // Getter methods
    public Book getBook() {
        return book;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void markReturned() {
        this.returnDate = LocalDate.now();
        book.setBorrowed(false);
    }

    @Override
    public String toString() {
        return String.format("%s borrowed by %s on %s%s",
                book.getTitle(), borrower.getName(), borrowDate,
                returnDate != null ? ", returned on " + returnDate : "");
    }
}