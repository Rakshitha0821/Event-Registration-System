package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DBConnection;

public class RegistrationDAO {

    // Register user for event
    public void registerEvent(int userId, int eventId) {
        try {
            Connection con = DBConnection.getConnection();
            String query = "INSERT INTO registrations(user_id, event_id) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, userId);
            ps.setInt(2, eventId);

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View registered events for a user
    public void viewUserRegistrations(int userId) {
        try {
            Connection con = DBConnection.getConnection();
            String query =
                "SELECT e.event_name, e.event_date, e.location " +
                "FROM events e JOIN registrations r ON e.event_id = r.event_id " +
                "WHERE r.user_id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            System.out.println("\nYour Registered Events:");
            System.out.println("--------------------------------");

            while (rs.next()) {
                System.out.println(
                        "Event: " + rs.getString("event_name") +
                        ", Date: " + rs.getString("event_date") +
                        ", Location: " + rs.getString("location")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
