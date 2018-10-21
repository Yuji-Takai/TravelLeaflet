package edu.gatech.travelleaflet.Models;
import java.time.LocalDate;
import java.util.*;

public class Trip{
    private List<Event> schedule;
    private List<Item> checkList;
    private List<String> tripmates;
    private String city;
    private Date start;
    private Date end;

    public Trip() { }

    public Trip(String city, Date start, Date end, String userid) {
        this.city = city;
        this.start = start;
        this.end = end;
        schedule = new ArrayList<Event>();
        checkList = new ArrayList<Item>();
        tripmates = new ArrayList<String>();
        tripmates.add(userid);
    }


    public List<Event> getSchedule() { return this.schedule; }

    public List<Item> getItems() {
        return this.checkList;
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

    public void addTripmate(String user) {
        tripmates.add(user);
    }

    public void removeTripmate(String user) {
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