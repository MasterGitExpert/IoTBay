/* Test file for anything sql */

SELECT * FROM Users WHERE email = 'admin@mail.com' AND pass = 'iotadmin';
SELECT * FROM Users WHERE email = 'admin' -- ' AND pass = 'iotadmin';
SELECT * FROM Users WHERE email = 'admin' AND pass = 'iotadmin';
SELECT * FROM Users WHERE email = 'admin' /* ' AND pass = 'iotadmin'; */
SELECT * FROM Users WHERE email = 'admin' AND pass = 'iotadmin';