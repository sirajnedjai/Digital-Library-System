package models;

public class EBook extends Book {
    private String fileFormat;

    public EBook(String title, String author, String isbn, String fileFormat) {
        super(title, author, isbn);
        this.fileFormat = fileFormat;
    }

    @Override
    public String getBookType() {
        return "E-Book (" + fileFormat + ")";
    }

    @Override
    public String toString() {
        return super.toString() + " | Format: " + fileFormat;
    }
}