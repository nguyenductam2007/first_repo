import java.time.LocalDateTime;

public class Ticket {
    String id;
    String content;
    LocalDateTime timestamp;

    public Ticket(String id, String content, LocalDateTime timestamp) {
        this.id = id;
        this.content = content;
        this.timestamp = timestamp;
    }
}