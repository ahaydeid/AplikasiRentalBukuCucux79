public class BookForLoan extends Book {
    private double bookLoanPrice;
    private int stock;

    public BookForLoan(String bookId, String title, String author, double bookPrice, double bookLoanPrice, int stock) {
        super(bookId, title, author, bookPrice);
        this.bookLoanPrice = bookLoanPrice;
        this.stock = stock;
    }


//1. Ketentuan untuk menghitung Harga buku (calculateBookLoanPrice()) = berdasarkan Stock dan Jenis Buku:
//    Jika Stock dibawah 10, maka Harga Pinjam adalah 5% dari harga buku
//    Jika Stock 10 keatas, maka Harga Pinjam adalah 3% dari harga buku
//
//    Jika Buku adalah Comic, maka Harga Pinjam adalah 10% dari harga buku
//    Jika Buku adalah Novel, maka Harga Pinjam adalah 5% dari harga buku
//
//    Kalkulasi Harga buku (calculateBookLoanPrice());
//    (RateStockPercentage + RateBookType) * Harga Buku.
//
//
// 2. Ketentuan untuk menghitung Loan Fee = lama peminjaman * Harga buku.

    @Override
    public double calculateBookLoanPrice() {
        double rateStockPercentage = (stock >= 10) ? 0.03 : 0.05;
        double rateBookType = (this instanceof Comic) ? 0.1 : 0.05;
        return Math.round((rateStockPercentage + rateBookType) * getBookPrice());
    }

    public int getStock() {
        return stock;
    }

    public void decreaseStock() {
        stock--;
    }

    public void increaseStock() {
        stock++;
    }
}
