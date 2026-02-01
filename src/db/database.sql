-- Create Database
CREATE DATABASE IF NOT EXISTS event_db;
USE event_db;

-- Users Table
CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    role VARCHAR(20) NOT NULL
);

-- Events Table
CREATE TABLE events (
    event_id INT AUTO_INCREMENT PRIMARY KEY,
    event_name VARCHAR(100) NOT NULL,
    event_date DATE NOT NULL,
    location VARCHAR(100) NOT NULL,
    capacity INT NOT NULL
);

-- Registrations Table
CREATE TABLE registrations (
    registration_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    event_id INT,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (event_id) REFERENCES events(event_id)
);

-- Sample Data (Optional but good for demo)

INSERT INTO users (name, email, password, role)
VALUES ('Admin', 'admin@gmail.com', 'admin123', 'ADMIN');

INSERT INTO events (event_name, event_date, location, capacity)
VALUES 
('Tech Fest', '2026-03-15', 'College Auditorium', 100),
('Coding Contest', '2026-03-20', 'Computer Lab', 50);
