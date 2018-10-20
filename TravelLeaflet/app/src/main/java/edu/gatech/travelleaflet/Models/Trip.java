package edu.gatech.travelleaflet.Models;
import java.util.*;

public class Trip{
    private List<Event> schedule;
    private List<Item> checkList;
    private Set<User> tripmates;
    private String city;
    private Date start;
    private Date end;

    public Trip() { }

    public Trip(String city, Date start, Date end, User user) {
        this.city = city;
        this.start = start;
        this.end = end;
        schedule = new ArrayList<Event>();
        checkList = new ArrayList<Item>();
        tripmates = new HashSet<User>();
        tripmates.add(user);
    }

    public List<Event> getSchedule() {
        return schedule;
    }

    public List<Item> getItems() {
        return checkList;
    }

    public void addEvent(Event e) {
        schedule.add(e);
    }

    public void removeEvent(Event e) {
        schedule.remove(e);
    }

    public void addItem(Item i) {
        checkList.add(i);
    }

    public void removeItem(Item i) {
        checkList.remove(i);
    }

    public void addTripmate(User user) {
        tripmates.add(user);
    }

    public void removeTripmate(User user) {
        tripmates.remove(user);
    }

    public void setDestination(String city) {
        this.city = city;
    }

    public String getDestination() {
        return city;
    }

    public void setStartDate(Date start) {
        this.start = start;
    }

    public Date getStartDate() {
        return start;
    }

    public void setEndDate(Date end) {
        this.end = end;
    }

    public Date getEndDate() {
        return end;
    }
}