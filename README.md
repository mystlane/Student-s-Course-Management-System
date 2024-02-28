# Student-s-Course-Management-System

## Overview
The Students’ Course Management System is designed to facilitate the efficient management and organization of courses for students. It provides functionalities for adding, deleting, viewing, and updating course information. Additionally, the system stores student data in a database, accessible to authorized personnel such as instructors or administrators. This project is open-source.

## Technologies Used
Programming Language: Java
Integrated Development Environment (IDE): Eclipse IDE for Java Developers 2020-06
Graphical User Interface (GUI): Eclipse WindowBuilder
Database Connectivity: JDBC (Java Database Connectivity)
Database Management System (DBMS): MySQL
Web-based Database Administration: phpMyAdmin
Local Server Environment: XAMPP

## Development Process
The system was developed using Java programming language with a focus on creating a user-friendly GUI for enhanced efficiency. Eclipse IDE, equipped with WindowBuilder, facilitated rapid development by simplifying the GUI design process. JDBC was utilized for database connectivity, with MySQL serving as the backend database managed via phpMyAdmin. XAMPP was employed to set up a local server environment for development purposes.

## Installation Instructions
To install and run the Students’ Course Management System, follow these steps:

1. Download and Install Eclipse IDE: Download the Eclipse IDE for Java Developers 2020-06 from the official website.
Follow the installation instructions provided on the website or included in the downloaded package.
Install WindowBuilder Plugin:

2. Launch Eclipse IDE.
Navigate to Help > Eclipse Marketplace.
Search for "WindowBuilder" and install the plugin.
Follow any additional prompts to complete the installation.


3. Download and Configure XAMPP:
Download XAMPP from the official website and follow the installation instructions.
Start the Apache and MySQL services using the XAMPP Control Panel.


4.Import Project: Download the Students’ Course Management System project files.
Open Eclipse IDE and import the project into your workspace.

5.Configure JDBC:
Ensure that the MySQL connector JAR is included in the project's classpath.
If not, download the MySQL connector JAR and add it to the project's build path.


6.Database Setup:
Access phpMyAdmin through your web browser (typically http://localhost/phpmyadmin).
Create a new database for the Students’ Course Management System.
Overview of the two tables you've created in MySQL:

**Course Table (course):**
**Columns:**
Code:  Unique identifier for the course.
Name: Name of the course.
Instructor:  Name of the instructor teaching the course.
Room:  - Room where the course is conducted.
Primary Key: Code
**Student Information Table (studentinfo):**
**Columns:**
Username:Unique identifier for the student.
Password: Password for the student's account (please note that storing passwords as plain text is not recommended for security reasons; consider using encryption or hashing).
LastName:  Last name of the student.
FirstName:  First name of the student.
MiddleName: Middle name of the student.
YearLevel: Year level of the student.
Program: Program in which the student is enrolled.
Primary Key: Username

7. Run the Application: Build the project in Eclipse IDE. 
Run the main Java file to start the application.

##Usage
Feel free to download and modify the code for your own purposes, whether it's for a class project, practicing Java programming, or any other educational endeavor. We encourage sharing within the community. Happy Coding!
