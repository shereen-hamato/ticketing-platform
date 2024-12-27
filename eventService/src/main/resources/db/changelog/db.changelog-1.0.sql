-- db.changelog-1.0.sql

-- Create the Event table with the new fields
CREATE TABLE event (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    location VARCHAR(255),
    date VARCHAR(255), -- Store date as a string or change to DATETIME type if needed
    created_by_username VARCHAR(255),
    created_by_full_name VARCHAR(255)
);

-- Insert some test data into the Event table with the new fields
INSERT INTO event (name, description, location, date, created_by_username, created_by_full_name)
VALUES
    ('Tech Conference 2024', 'A conference to discuss the latest trends in tech.', 'San Francisco, CA', '2024-03-15 09:00:00', 'techUser', 'John Doe'),
    ('Spring Boot Meetup', 'A meetup for Spring Boot enthusiasts.', 'New York, NY', '2024-04-01 18:00:00', 'springUser', 'Jane Smith');
