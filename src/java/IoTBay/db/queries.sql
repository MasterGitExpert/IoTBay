/* These are saple queries used in the program */

---------------------------------------------------------------------------
-------------------------------- Feature 1 --------------------------------
---------------------------------------------------------------------------

-- Create

INSERT INTO User(first_name, last_name, email, pass, phone, registration_date, access) 
VALUES ('coAdmin', 'coAdmin', 'co_admin@mail.com', 'co2admin143', '0123 456 789', '2020-1-1 00:00:00', 'ADMIN');

INSERT INTO UserAccessLog (user_id, login_datetime, logout_datetime)
VALUES (1, '2020-1-1 00:00:00', '2020-1-1 01:00:00');


-- Read

SELECT * FROM User
WHERE email = 'staff@mail.com';

SELECT * FROM User
WHERE email = 'admin@mail.com';

SELECT COUNT(*) as user_count FROM User
WHERE email = 'admin@mail.com'
AND pass = 'iotadmin';

SELECT * FROM User
WHERE email = 'un3@mail.com'
AND pass = 'password';

SELECT * FROM UserAccessLog
WHERE user_id = (
    SELECT user_id FROM User
    WHERE email = 'admin@mail.com'
    )
ORDER BY DESC;


-- Update

UPDATE User
SET first_name = 'Admin',
last_name = 'Admin',
email = 'admin@mail.com',
pass = 'iotadmin',
phone = '0123 456 789',
WHERE email = 'admin@mail.com';

UPDATE User
SET first_name = 'Admin',
last_name = 'Admin',
email = 'admin@mail.com',
pass = 'iotadmin',
phone = '0123 456 789',
WHERE email = 'admin@mail.com';


-- Delete

DELETE FROM User
WHERE email = 'un5@gmail.com';

DELETE FROM User
WHERE email = 'staff3@gmail.com';



---------------------------------------------------------------------------
-------------------------------- Feature 2 --------------------------------
---------------------------------------------------------------------------

-- Create

-- Read

-- Update

-- Delete



---------------------------------------------------------------------------
-------------------------------- Feature 3 --------------------------------
---------------------------------------------------------------------------

-- Create

-- Read

-- Update

-- Delete



---------------------------------------------------------------------------
-------------------------------- Feature 4 --------------------------------
---------------------------------------------------------------------------

-- Create

-- Read

-- Update

-- Delete



---------------------------------------------------------------------------
-------------------------------- Feature 5 --------------------------------
---------------------------------------------------------------------------

-- Create

-- Read

-- Update

-- Delete


