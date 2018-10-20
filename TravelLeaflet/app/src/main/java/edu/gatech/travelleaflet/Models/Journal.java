package edu.gatech.travelleaflet.Models;
import java.util.*;

public class Journal {
    private final User author;
    private final int visibility;
    private final List<Event> schedule;

    public Journal(User author, int visibility, List<Event> schedule) {
        this.author = author;
        this.visibility = visibility;
        this.schedule = schedule;
    }
}