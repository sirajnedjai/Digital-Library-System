package models;

public class PaperBook extends Book {
    private int pageCount;

    public PaperBook(String title, String author, String isbn, int pageCount) {
        super(title, author, isbn);
        this.pageCount = pageCount;
    }

    @Override
    public String getBookType() {
        return "Paper Book (" + pageCount + " pages)";
    }

    @Override
    public String toString() {
        return super.toString() + " | Pages: " + pageCount;
    }
}