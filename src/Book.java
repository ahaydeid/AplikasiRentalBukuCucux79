public abstract class Book implements Loanable {
    private String bookId;
    private String title;
    private String author;
    private double bookPrice;

    public Book(String bookId, String title, String author, double bookPrice) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.bookPrice = bookPrice;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public abstract double calculateBookLoanPrice();
}
