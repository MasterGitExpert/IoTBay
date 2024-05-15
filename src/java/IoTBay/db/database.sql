/* This script clears and recreates db from scratch*/

-- Clean db
DROP TABLE UserAccessLog;
DROP TABLE Users;


---------------------------------------------------------------------------
-------------------------------- Feature 1 --------------------------------
---------------------------------------------------------------------------

-- Create users table
CREATE TABLE Users (
    user_id int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    first_name VARCHAR(64),
    last_name VARCHAR(64),
    email VARCHAR(255) UNIQUE,
    pass VARCHAR(64),
    dob DATE,
    phone VARCHAR (16),
    registration_datetime TIMESTAMP,
    access VARCHAR(8),
    CONSTRAINT access_constraint CHECK(access IN ('CUSTOMER', 'STAFF', 'ADMIN'))
);

-- Inserts dummy values into users table
INSERT INTO Users (first_name, last_name, email, pass, phone, registration_datetime, access) 
VALUES
('Admin', 'Admin', 'admin@mail.com', 'iotadmin', '0123 456 789', '2020-1-1 00:00:00', 'ADMIN'),
('Staff1', 'Staff1', 'staff1@mail.com', 'staff21', '0123 456 789', '2010-1-1 00:00:00', 'STAFF'),
('Staff2', 'Staff2', 'staff2@mail.com', 'staff15...', '0123 456 789', '2010-1-1 00:00:00', 'STAFF'),
('Staff3', 'Staff3', 'staff3@mail.com', 'ffastnnnfurioussss3', '0123 456 789', '2010-1-1 00:00:00', 'STAFF'),
('User1', 'Name1', 'un1@mail.com', '1234', '0123 456 789', '2000-1-1 00:00:00', 'CUSTOMER'),
('User2', 'Name2', 'un2@mail.com', '4321', '0123 456 789', '2000-1-1 00:00:00', 'CUSTOMER'),
('User3', 'Name3', 'un3@mail.com', 'password', '0123 456 789', '2000-1-1 00:00:00', 'CUSTOMER'),
('User4', 'Name4', 'un4@mail.com', 'un54321', '0123 456 789', '2000-1-1 00:00:00', 'CUSTOMER'),
('User5', 'Name5', 'un5@mail.com', 'isNotApass_hacker8', '0123 456 789', '2000-1-1 00:00:00', 'CUSTOMER'),
('User6', 'Name6', 'un6@mail.com', 'Crypt03xpert*', '0123 456 789', '2000-1-1 00:00:00', 'CUSTOMER'),
('User7', 'Name7', 'un7@mail.com', 'mypass2.0', '0123 456 789', '2000-1-1 00:00:00', 'CUSTOMER'),
('User8', 'Name8', 'un8@mail.com', '1ntroducti0nT0S0ftwareDev', '0123 456 789', '2000-1-1 00:00:00', 'CUSTOMER');

-- Create user access log table
CREATE TABLE UserAccessLog (
    ual_id int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    user_id int,
    login_datetime TIMESTAMP,
    logout_datetime TIMESTAMP,
    CONSTRAINT user_fk FOREIGN KEY (user_id) REFERENCES Users(user_id)
);



---------------------------------------------------------------------------
-------------------------------- Feature 2 --------------------------------
---------------------------------------------------------------------------



---------------------------------------------------------------------------
-------------------------------- Feature 3 --------------------------------
---------------------------------------------------------------------------



---------------------------------------------------------------------------
-------------------------------- Feature 4 --------------------------------
---------------------------------------------------------------------------



---------------------------------------------------------------------------
-------------------------------- Feature 5 --------------------------------
---------------------------------------------------------------------------





-- Database Encryption Testing 

-- -- Using master db 
-- USE MASTER;

-- -- Creating a master key by password for encryption 
-- CREATE MASTER KEY ENCRYPTION BY PASSWORD = 'IotPassword';

-- -- Creating a certificate
-- CREATE CERTIFICATE ServerCertificate WITH SUBJECT = 'Iot Certificate';

-- -- Using the current db
-- USE iotdb;

-- -- Creating a encrypt data for the certificate using AES-256
-- CREATE DATABASE ENCRYPTION KEY
-- WITH ALGORITHM = AES_256
-- ENCRYPTION BY SERVER CERTIFICATE ServerCertificate;

-- -- Applying encryption on db
-- ALTER DATABASE iotdb
-- SET ENCRYPTION ON;