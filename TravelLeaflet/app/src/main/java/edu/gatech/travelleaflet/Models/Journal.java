import java.util.*;

public class Journal {
    private final User author;
    private final int visibility;
    private final List<Events> schedule;

    public Journal(User author, int visibility, List<Events> schedule) {
        this.author = author;
        this.visibility = visibility;
        this.schedule = schedule;
    }
}