-- Create new user (schema)
CREATE USER assignment2 IDENTIFIED BY 1234;

-- Grant permissions to connect and create basic objects to new users
GRANT CONNECT, RESOURCE TO assignment2;

-- Grant permissions to tablespaces users
ALTER USER assignment2 QUOTA UNLIMITED ON USERS;

-- Alter session to WAREHOUSE_MANAGEMENT
ALTER SESSION SET current_schema = assignment2;