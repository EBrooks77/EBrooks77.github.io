# Databases

The artifact I selected for the databases prompt was the final project from my Introduction to Structured Database Environments course. The final project involved navigating an existing database, adding information, and generating outputs to demonstrate a thorough understanding of SQL and database structure. I included this project because it shows my knowledge of working with databases to navigate database structure, update information, and generate outputs of data combined from multiple tables in the database.

In the final project, all of the inputs were done manually. For this prompt I have gone back and shown how new data can be added from a Comma Separated Values (CSV) file rather than entering each line by hand. This option automates much of the process to bring in data. There are common tools which can perform this action, but it is also good to know how to import the data without tools.

While this was a successful implementation of the addition I wanted, I discovered that it is easy to run into errors when importing data this way. Moving forward I would add a step of bringing the data into a temporary table to make sure that it came in correctly and then updating the live table after.

[Database Automation](https://github.com/EBrooks77/EBrooks77.github.io/blob/main/ErinBrooks_CS499_Databases/ErinBrooks_CS499_DatabasesNarrative.docx)


```sql

mysql> SHOW DATABASES;  -- View available databases
mysql> USE messaging;   -- Enter messaging database

mysql> SHOW TABLES;     -- View available tables

-- View the columns available in each table
mysql> SHOW COLUMNS FROM contact_list;  
mysql> SHOW COLUMNS FROM message;
mysql> SHOW COLUMNS FROM person;

-- Add Erin Hendrickson to the persons table
mysql> INSERT INTO person (first_name,last_name) VALUES ("Erin","Hendrickson");
mysql> SELECT * FROM person;

-- Add a new column to the person table to include gender
mysql> ALTER TABLE person ADD gender VARCHAR(1) DEFAULT NULL;
mysql> SHOW COLUMNS FROM person;

-- Update person_id 7 to female
mysql> UPDATE person SET gender = "f" WHERE person_id = 7;
mysql> SELECT * FROM person;

-- Delete Diana Taurasi from persons
mysql> DELETE FROM person WHERE first_name = "Diana" AND last_name = "Taurasi";
mysql> SELECT * FROM person;

-- Automatically add in additional persons from a CSV file rather than manually adding in each line (need full location of the file when actually in use)
mysql> BULK INSERT person FROM 'personslist.csv'; 
mysql> SELECT * FROM person;

-- Add a new column to contact_list to include option of favorite
mysql> ALTER TABLE contact_list ADD favorite VARCHAR(10) DEFAULT NULL;
mysql> SHOW COLUMNS FROM contact_list;

-- Manually update contact_id 1 to yes for favorite
mysql> UPDATE contact_list SET favorite = 'y' WHERE contact_id = 1;
mysql> SELECT * FROM contact_list;

-- Manually update contact_id 2 thru 7 to no for favorite
mysql> UPDATE contact_list SET favorite = 'n' WHERE contact_id BETWEEN 2 AND 7;
mysql> SELECT * FROM contact_list;

-- Batch update three more favorite options to yes or no
mysql> INSERT INTO contact_list (person_id,contact_id,favorite) VALUES
    -> (1,7,'y'),
    -> (3,7,'n'),
    -> (5,7,'n');
mysql> SELECT * FROM contact_list;

-- Create image table
mysql> CREATE TABLE image (
    -> image_id INT(8) UNSIGNED NOT NULL auto_increment,
    -> image_name VARCHAR(50) NOT NULL,
    -> image_location VARCHAR(250) NOT NULL,
    -> PRIMARY KEY (image_id)
    -> ) AUTO_INCREMENT=1;
mysql> SHOW COLUMNS iamge;

-- Create messsage_image table
mysql> CREATE TABLE message_image (
    -> message_id INT(8) UNSIGNED NOT NULL,
    -> image_id INT(8) UNSIGNED NOT NULL);
mysql> SHOW COLUMNS FROM message_image;

-- Manually add 5 images
mysql> INSERT INTO image (image_name,image_location) VALUES
    -> ('Fast 50 free!','Pool deck'),
    -> ('Awesome warm-up','Pool deck'),
    -> ('Getting ready to compete!','Olive Garden'),
    -> ('Needed a new suit','TYR Shop'),
    -> ('Goona be a gold!','Starting Block');
mysql> SELECT * FROM image;

-- Check message table
mysql> SELECT * FROM message;

-- Manually match images to messages in message_image
mysql> INSERT INTO message_image (message_id,image_id) VALUES
    -> (1,1),
    -> (2,5),
    -> (3,2),
    -> (4,4),
    -> (5,3);
mysql> SELECT * FROM message_image;

-- Display all messages sent by Michael Phelps, including information of the message, receiver, message ID, and timestamp
mysql> SELECT
    -> s.first_name AS sender_first_name,
    -> s.last_name AS sender_last_name,
    -> r.first_name AS receiver_first_name,
    -> r.last_name AS receiver_last_name,
    -> message_id,
    -> message,
    -> send_datetime AS message_timestamp
    -> FROM message
    -> JOIN person AS s ON s.person_id = message.sender_id
    -> JOIN person AS r ON r.person_id = message.receiver_id
    -> WHERE s.first_name = 'Michael' AND s.last_name = 'Phelps';

-- Display a count of messages sent by each person, ordered from greatest to least
mysql> SELECT
    -> COUNT(message_id) AS count_of_messages,
    -> sender_id AS person_id,
    -> first_name,
    -> last_name
    -> FROM message
    -> JOIN person ON message.sender_id = person.person_id
    -> GROUP BY sender_id;

-- Display all messages sent and include the image name and location
mysql> SELECT
    -> message.message_id, message, send_datetime AS message_timestamp, image_name, image_location
    -> FROM message
    -> INNER JOIN message_image ON message.message_id = message_image.message_id
    -> INNER JOIN image ON message_image.image_id = image.image_id;

```
