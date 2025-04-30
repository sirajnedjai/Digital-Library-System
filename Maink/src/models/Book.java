package models;

public abstract class Book {
    protected String title;
    protected String author;
    protected String isbn;
    protected boolean isBorrowed;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isBorrowed = false;
    }

    // Getters and setters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public boolean isBorrowed() { return isBorrowed; }
    public void setBorrowed(boolean borrowed) { isBorrowed = borrowed; }

    public abstract String getBookType();

    @Override
    public String toString() {
        return String.format("%s by %s (ISBN: %s) - %s",
                title, author, isbn, isBorrowed ? "Borrowed" : "Available");
    }
}