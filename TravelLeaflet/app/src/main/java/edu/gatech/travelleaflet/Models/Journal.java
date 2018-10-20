package edu.gatech.travelleaflet.Models;
import java.util.*;

public class Journal {
    private User author;
    private int visibility;
    private List<Event> schedule;

    public Journal() { }

    public Journal(User author, int visibility, List<Event> schedule) {
        this.author = author;
        this.visibility = visibility;
        this.schedule = schedule;
    }
}