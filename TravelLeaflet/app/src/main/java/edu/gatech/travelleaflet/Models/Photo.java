package edu.gatech.travelleaflet.Models;
public class Photo {
    private String name;
    private String url;
    private static int count = 0;

    public Photo() {}

    public Photo(String name) {
        if (name.trim().equals("")) {
            name = "NoName_" + count;
            count++;
        }
        this.name = name;
        this.url = "";
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setUrl (String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}