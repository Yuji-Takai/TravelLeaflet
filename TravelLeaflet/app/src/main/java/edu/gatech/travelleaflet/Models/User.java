package edu.gatech.travelleaflet.Models;
import java.util.*;

public class User {
    private String name;
    private final int uid;
    private Set<User> friends;
    private List<Trip> trips;

    public User(String name, int uid) {
        this.name = name;
        this.uid = uid;
        friends = new HashSet<User>();
        trips = new ArrayList<Trip>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

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