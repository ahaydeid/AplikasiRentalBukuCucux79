import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CucuxApp {
    private List<BookForLoan> books;
    private List<Member> members;
    private List<LoanBookOrder> loanOrders;
    private RepositoryBookForLoan bookRepository;
    private RepositoryMember memberRepository;
    private Scanner sc;

    public CucuxApp() {
        sc = new Scanner(System.in);
        bookRepository = new RepositoryBookForLoan();
        memberRepository = new RepositoryMember();
        books = bookRepository.getAllBooksForLoan();
        members = memberRepository.getAllMembers();
        loanOrders = new ArrayList<>();
    }

    public void listAllBooks() {
        System.out.println("List of Books:");
        for (BookForLoan book : books) {
            System.out.println("Book ID: " + book.getBookId());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Stock: " + book.getStock());
            System.out.println();
        }
    }

    public void loanBook() {
        sc.nextLine();
        System.out.println("Enter Member ID: ");
        String memberId = sc.nextLine();

        // Cek member
        Member member = null;
        for (Member m : members) {
            if (m.getMemberId().equals(memberId)) {
                member = m;
                break;
            }
        }

        if (member == null) {
            System.out.println("Member not found.");
            return;
        }

        System.out.println("Enter Book ID: ");
        String bookId = sc.nextLine();

        BookForLoan book = null;
        for (BookForLoan b : books) {
            if (b.getBookId().equals(bookId) && b.getStock() > 0) {
                book = b;
                break;
            }
        }

        if (book == null) {
            System.out.println("Book not found or not available for loan.");
            return;
        }

        System.out.println("Enter Loan Duration (in days): ");
        int loanDuration = sc.nextInt();

        String loanId = "LOAN-" + System.currentTimeMillis(); // Generate loanID unik
        LoanBookOrder loanOrder = new LoanBookOrder(loanId, member, book, loanDuration);
        loanOrders.add(loanOrder);
        book.decreaseStock();

        // Print detail Loan
        System.out.println("Loan ID: " + loanId);
        System.out.println("Member Name: " + member.getMemberName());
        System.out.println("Book ID: " + book.getBookId());
        System.out.println("Title: " + book.getTitle());
        System.out.println("Book Loan Price: " + book.calculateBookLoanPrice());
        System.out.println("Loan Duration: " + loanDuration + " days");
        System.out.println("Loan Fee: " + loanOrder.calculateLoanFee());


    }



    public void returnBook() {
        sc.nextLine();
        System.out.println("Enter Loan ID: ");
        String loanId = sc.nextLine();

        LoanBookOrder loanOrder = null;
        for (LoanBookOrder order : loanOrders) {
            if (order.getLoanId().equals(loanId)) {
                loanOrder = order;
                break;
            }
        }

        if (loanOrder == null) {
            System.out.println("Loan order not found.");
            return;
        }

        BookForLoan returnedBook = loanOrder.getLoanBook();
        returnedBook.increaseStock();
        double returnFee = loanOrder.calculateLoanFee();

        loanOrders.remove(loanOrder);

        System.out.println("Loan ID: " + loanOrder.getLoanId());
        System.out.println("Member Name: " + loanOrder.getMember().getMemberName());
        System.out.println("Book ID: " + returnedBook.getBookId());
        System.out.println("Title: " + returnedBook.getTitle());
        System.out.println("Book Loan Price: " + returnedBook.calculateBookLoanPrice());
        System.out.println("Loan Duration: " + loanOrder.getLoanDuration() + " days");
        System.out.println("Loan Fee: " + returnFee);
    }



    public void listLoanOrders() {
        System.out.println("List of Loan Orders:");
        for (LoanBookOrder order : loanOrders) {
            System.out.println("Loan ID: " + order.getLoanId());
            System.out.println("Member Name: " + order.getMember().getMemberName());
            System.out.println("Book ID: " + order.getLoanBook().getBookId());
            System.out.println("Title: " + order.getLoanBook().getTitle());
            System.out.println("Book Loan Price: " + order.getLoanBook().calculateBookLoanPrice());
            System.out.println("Loan Duration: " + order.getLoanDuration() + " days");
            System.out.println("Loan Fee: " + order.calculateLoanFee());
            System.out.println();
        }
    }

    public void mainMenu() {
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Data All Book For Loan");
            System.out.println("2. Loan");
            System.out.println("3. Return");
            System.out.println("4. Data All Loan Book Order");
            System.out.println("5. Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    listAllBooks();
                    break;
                case 2:
                    loanBook();
                    break;
                case 3:
                    returnBook();
                    break;
                case 4:
                    listLoanOrders();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);
    }

    public static void main(String[] args) {
        CucuxApp app = new CucuxApp();
        app.mainMenu();
    }
}
