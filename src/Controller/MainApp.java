package controller;

import java.util.Scanner;

import dao.EventDAO;
import dao.RegistrationDAO;
import dao.UserDAO;
import model.Event;
import model.User;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UserDAO userDAO = new UserDAO();
        EventDAO eventDAO = new EventDAO();
        RegistrationDAO registrationDAO = new RegistrationDAO();

        System.out.println("=================================");
        System.out.println(" ONLINE EVENT REGISTRATION SYSTEM ");
        System.out.println("=================================");

        while (true) {
            System.out.println("\n1. Register User");
            System.out.println("2. Login");
            System.out.println("3. Add Event (Admin)");
            System.out.println("4. Register for Event");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Password: ");
                    String password = sc.nextLine();

                    User user = new User(name, email, password, "USER");
                    userDAO.registerUser(user);

                    System.out.println("✅ User Registered Successfully!");
                    break;

                case 2:
                    System.out.print("Enter Email: ");
                    String loginEmail = sc.nextLine();

                    System.out.print("Enter Password: ");
                    String loginPassword = sc.nextLine();

                    User loggedUser = userDAO.login(loginEmail, loginPassword);

                    if (loggedUser != null) {
                        System.out.println("✅ Login Successful!");
                        System.out.println("Welcome, " + loggedUser.getName());
                    } else {
                        System.out.println("❌ Invalid Credentials");
                    }
                    break;

                case 3:
                    System.out.print("Enter Event Name: ");
                    String eventName = sc.nextLine();

                    System.out.print("Enter Event Date (YYYY-MM-DD): ");
                    String eventDate = sc.nextLine();

                    System.out.print("Enter Location: ");
                    String location = sc.nextLine();

                    System.out.print("Enter Capacity: ");
                    int capacity = sc.nextInt();

                    Event event = new Event(eventName, eventDate, location, capacity);
                    eventDAO.addEvent(event);

                    System.out.println("✅ Event Added Successfully!");
                    break;

                case 4:
                    System.out.print("Enter User ID: ");
                    int userId = sc.nextInt();

                    System.out.print("Enter Event ID: ");
                    int eventId = sc.nextInt();

                    registrationDAO.registerEvent(userId, eventId);

                    System.out.println("✅ Event Registered Successfully!");
                    break;

                case 5:
                    System.out.println("Thank you for using the system!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("❌ Invalid Choice");
            }
        }
    }
}
