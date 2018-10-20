package edu.gatech.travelleaflet.Models;
import java.io.Serializable;
import java.util.*;

public class User implements Serializable {
    private String name;
    private int tripCount;
    private Set<User> friends;
    private List<Trip> trips;

    public User() { }

    public User(String name) {
        this.name = name;
        this.tripCount = 0;
        friends = new HashSet<User>();
        trips = new ArrayList<Trip>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addTripCount() { this.tripCount++; }
    public int getTripCount() { return tripCount; }

    public void addFriend(User user) {
        friends.add(user);
    }

    public void removeFriend(User user) {
        friends.remove(user);
    }

    public void addTrip(Trip trip) {
        trips.add(trip);
    }

    public void removeTrip(Trip trip) {
        trips.remove(trip);
    }
}