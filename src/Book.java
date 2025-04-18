public class Book {
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;

    public Book(int id, String isbn, String title) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = false;
        this.checkedOutTo = "";
    }

    // Getters
    public int getId() { return id; }
    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public boolean getIsCheckedOut() { return isCheckedOut; }
    public String getCheckedOutTo() { return checkedOutTo; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public void setTitle(String title) { this.title = title; }

    // Methods
    public void checkOut(String name) {
        if (!isCheckedOut) {
            this.isCheckedOut = true;
            this.checkedOutTo = name;
        }
    }

    public void checkIn() {
        this.isCheckedOut = false;
        this.checkedOutTo = "";
    }
    public String checkedOutInfo() {
        return toString() + ", Checked Out To: " + checkedOutTo;
    }
    @Override
    public String toString() {
        return "ID: " + id + ", ISBN: " + isbn + ", Title: " + title;
    }
}
