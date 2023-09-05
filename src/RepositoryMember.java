import java.util.ArrayList;
import java.util.List;

public class RepositoryMember {
    private List<Member> members;

    public RepositoryMember() {
        members = new ArrayList<>();
        // Inisialisasi data member
        members.add(new Member("M-001", "Risman", "Bandung"));
        members.add(new Member("M-002", "Budi", "Bandung"));
        members.add(new Member("M-003", "Resti", "Kab. Bandung"));
        members.add(new Member("M-004", "Ahadi", "Tangerang"));

    }

    public List<Member> getAllMembers() {
        return members;
    }
}
