import java.util.ArrayList;
import java.util.List;

public class RepositoryBookForLoan {
    private List<BookForLoan> booksForLoan;

    public RepositoryBookForLoan() {
        booksForLoan = new ArrayList<>();
        booksForLoan.add(new Comic("Comic-001", "Uzumaki Naruto", "Masashi Kisimoto", 55000, 0.0, 10, "Shounen"));
        booksForLoan.add(new Comic("Comic-002", "The Worst Client", "Masashi Kisimoto", 35000, 0.0, 20, "Shounen"));
        booksForLoan.add(new Comic("Comic-003", "For the Sake of Dreams...!!", "Masashi Kisimoto", 35000, 0.0, 15, "Shounen"));
        booksForLoan.add(new Comic("Comic-004", "Hunter X Hunter : The Day of Departure", "Yoshihiro Togashi", 50000, 0.0, 15, "Fantasy"));
        booksForLoan.add(new Comic("Comic-005", "Hunter X Hunter : A Struggle in the Mist", "Yoshihiro Togashi", 80000, 0.0, 25, "Fantasy"));
        booksForLoan.add(new Novel("Novel-001", "Harry Potter and the Philosopher's Stone", "J.K Rowling", 150000, 0.0, 10, true));
        booksForLoan.add(new Novel("Novel-002", "Harry Potter and the Chamber of Secrets", "J.K Rowling", 150000, 0.0, 10, true));
        booksForLoan.add(new Novel("Novel-003", "Harry Potter and the Prisoner of Azkaban", "J.K Rowling", 200000, 0.0, 15, true));
        booksForLoan.add(new Novel("Novel-004", "Ayah Aku Berbeda", "Tere Liye", 35000, 0.0, 15, false));
        booksForLoan.add(new Novel("Novel-005", "Madre ", "Dee Lestari",80000, 0.0, 10, false));
    }

    public List<BookForLoan> getAllBooksForLoan() {
        return booksForLoan;
    }
}
