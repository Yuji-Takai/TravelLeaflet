import android.provider.Contacts;

import java.util.*;

public class Event{
    private int type;
    private Date start_time;
    private Date end_time;
    private String activity;
    private String location;
    private Set<Photo> photos;
    private String comment;

    public Event(int type, Date start_time, Date end_time, String activity, String location) {
        this.type = type;
        this.start_time = start_time;
        this.end_time = end_time;
        this.activity = activity;
        this.location = location;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setStartTime(Date start_time) {
        this.start_time = start_time;
    }

    public Date getStartTime() {
        return start_time;
    }

    public void setEndTime(Date end_time) {
        this.end_time = end_time;
    }

    public Date getEndTime() {
        return end_time;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getActivity() {
        return activity;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public void addPhoto(Photo photo) {
        photos.add(photo);
    }

    public void removePhoto(Photo photo) {
        photo.remove(photo);
    }
}