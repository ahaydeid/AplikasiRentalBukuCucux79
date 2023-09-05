public class Member {
    private String memberId;
    private String memberName;
    private String address;

    public Member(String memberId, String memberName, String address) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.address = address;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getAddress() {
        return address;
    }
}
