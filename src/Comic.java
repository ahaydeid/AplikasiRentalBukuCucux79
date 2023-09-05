public class Comic extends BookForLoan {
    private String genre;

    public Comic(String bookId, String title, String author, double bookPrice, double bookLoanPrice, int stock, String genre) {
        super(bookId, title, author, bookPrice, bookLoanPrice, stock);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }
}
