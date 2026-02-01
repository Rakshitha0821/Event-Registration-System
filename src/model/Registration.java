package model;

public class Registration {

    private int registrationId;
    private int userId;
    private int eventId;

    public Registration() {
        // default constructor
    }

    public Registration(int userId, int eventId) {
        this.userId = userId;
        this.eventId = eventId;
    }

    // Getters and Setters
    public int getRegistrationId() {
        return registrationId;
    }
 
    public void setRegistrationId(int registrationId) {
        this.registrationId = registrationId;
    }
 
    public int getUserId() {
        return userId;
    }
 
    public void setUserId(int userId) {
        this.userId = userId;
    }
 
    public int getEventId() {
        return eventId;
    }
 
    public void setEventId(int eventId) {
        this.eventId = eventId;
    }
}
