package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Event;
import util.DBConnection;

public class EventDAO {

    // Add new event (Admin)
    public void addEvent(Event event) {
        try {
            Connection con = DBConnection.getConnection();
            String query = "INSERT INTO events(event_name, event_date, location, capacity) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, event.getEventName());
            ps.setString(2, event.getEventDate());
            ps.setString(3, event.getLocation());
            ps.setInt(4, event.getCapacity());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View all events
    public void viewEvents() {
        try {
            Connection con = DBConnection.getConnection();
            String query = "SELECT * FROM events";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            System.out.println("\nAvailable Events:");
            System.out.println("--------------------------------------");

            while (rs.next()) {
                System.out.println(
                        "ID: " + rs.getInt("event_id") +
                        ", Name: " + rs.getString("event_name") +
                        ", Date: " + rs.getString("event_date") +
                        ", Location: " + rs.getString("location") +
                        ", Capacity: " + rs.getInt("capacity")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
