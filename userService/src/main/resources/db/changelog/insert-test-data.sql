-- changeset admin:insert-test-data
INSERT INTO user_account_details (name, email, password, role)
VALUES
    ('John Doe', 'john.doe@example.com', 'password123', 'ROLE_USER'),
    ('Jane Admin', 'jane.admin@example.com', 'securepass', 'ROLE_ADMIN');
