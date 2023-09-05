public class LoanBookOrder {
    private String loanId;
    private Member member;
    private BookForLoan loanBook;
    private int loanDuration;

    public LoanBookOrder(String loanId, Member member, BookForLoan loanBook, int loanDuration) {
        this.loanId = loanId;
        this.member = member;
        this.loanBook = loanBook;
        this.loanDuration = loanDuration;
    }

    public double calculateLoanFee() {
        double bookLoanPrice = loanBook.calculateBookLoanPrice();
        return Math.round(loanDuration * bookLoanPrice);
    }

    public String getLoanId() {
        return loanId;
    }

    public Member getMember() {
        return member;
    }

    public BookForLoan getLoanBook() {
        return loanBook;
    }

    public int getLoanDuration() {
        return loanDuration;
    }
}
