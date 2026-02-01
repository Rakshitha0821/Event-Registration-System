package model;

public class Event {

    private int eventId;
    private String eventName;
    private String eventDate;
    private String location;
    private int capacity;

    public Event() {
        // default constructor
    }

    public Event(String eventName, String eventDate, String location, int capacity) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.location = location;
        this.capacity = capacity;
    }

    // Getters and Setters
    public int getEventId() {
        return eventId;
    }
 
    public void setEventId(int eventId) {
        this.eventId = eventId;
    }
 
    public String getEventName() {
        return eventName;
    }
 
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
 
    public String getEventDate() {
        return eventDate;
    }
 
    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }
 
    public String getLocation() {
        return location;
    }
 
    public void setLocation(String location) {
        this.location = location;
    }
 
    public int getCapacity() {
        return capacity;
    }
 
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
