# Student Management System

A Java-based Student Management System to manage student records using MySQL. Supports CRUD operations (Create, Read, Update, Delete), and organizes code using DAO, Model, Service layers.

---
## Features

- Add new student records  
- View existing student records  
- Update student information  
- Delete student records  
- Validation of user input  
- Layered architecture: DAO, Service, Model

---

## Technologies Used

- Java   
- MySQL 
- JDBC (using `mysql-connector-j`)  
- IDE ( VSCode)  

---

## Project Structure
StudentManagementSystem/
├── dao/ # Data Access Objects — handling DB operations
├── model/ # Java POJOs representing Student etc.
├── service/ # Business logic layer
├── util/ # Utility classes (e.g. DB connection helpers)
├── lib/mysql-connector-j-x.x.x/ # JDBC driver jar
└── main/ # Main application launcher / UI (Console or GUI)

##Usage

Run Main class
Choose an option:
1 → Add Student
2 → View Students
3 → Update Student
4 → Delete Student
5 → Exit

##🔮 Future Scope
GUI (Swing/JavaFX)
Search & filter features
User roles (Admin/Teacher)


