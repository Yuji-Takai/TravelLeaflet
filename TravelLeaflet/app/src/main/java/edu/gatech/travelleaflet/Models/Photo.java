package edu.gatech.travelleaflet.Models;
public class Photo {
<<<<<<< HEAD
    private String name;
    private String url;
    private static int count = 0;
=======
    public Photo() { }
>>>>>>> 8ecb26c7aeaa2838f3bbe4890e8b453f5a946a24

    public Photo() {}

    public Photo(String name, String url) {
        if (name.trim().equals("")) {
            name = "NoName_" + count;
            count++;
        }
        this.name = name;
        this.url = url;
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