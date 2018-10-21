package edu.gatech.travelleaflet.Models;
import java.io.Serializable;
import java.util.*;

public class User implements Serializable {
    private String name;
    private int tripCount;
    private List<String> friends;
    private List<String> trips;

    public User() { }

    public User(String name) {
        this.name = name;
        this.tripCount = 0;
        friends = new ArrayList<String>();
        trips = new ArrayList<String>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addTripCount() { this.tripCount++; }
    public int getTripCount() { return tripCount; }

    public void addFriend(String user) {
        friends.add(user);
    }

    public void removeFriend(String user) {
        friends.remove(user);
    }

    public List<String> getTrips() { return trips;}
    public void setTrips(List<String> trips) {this.trips = trips;}

    public void addTrip(String trip) {
        trips.add(trip);
    }

    public void removeTrip(String trip) {
        trips.remove(trip);
    }
}