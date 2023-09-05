public class Novel extends BookForLoan {
    private boolean isASeries;

    public Novel(String bookId, String title, String author, double bookPrice, double bookLoanPrice, int stock, boolean isASeries) {
        super(bookId, title, author, bookPrice, bookLoanPrice, stock);
        this.isASeries = isASeries;
    }

    public boolean isASeries() {
        return isASeries;
    }
}
