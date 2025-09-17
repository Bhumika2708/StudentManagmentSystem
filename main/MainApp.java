package main;

import service.StudentService;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        final String USERNAME = "admin";
        final String PASSWORD = "pass123";
        int attempts = 3;
        boolean loggedIn = false;

        Scanner scanner = new Scanner(System.in);  // ✅ declared once

       
        while (attempts > 0) {
            System.out.print("Enter admin username: ");
            String user = scanner.nextLine();

            System.out.print("Enter admin password: ");
            String pass = scanner.nextLine();

            if (user.equals(USERNAME) && pass.equals(PASSWORD)) {
                System.out.println("✅ Login successful!\n");
                loggedIn = true;
                break;
                
            } else {
                attempts--;
                System.out.println("❌ Invalid credentials. Attempts left: " + attempts);
            }
        }

        if (!loggedIn) {
            System.out.println("🚫 Too many failed attempts. Exiting...");
            return;
        }

      
        StudentService studentService = new StudentService();
        boolean exit = false;

        while (!exit) {
            System.out.println("\n========= Student Management Menu =========");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. View Student by ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter course: ");
                    String course = scanner.nextLine();
                    studentService.addStudent(name, age, course);
                }
                case 2 -> studentService.viewAllStudents();
                case 3 -> {
                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                    studentService.viewStudent(id);
                }
                case 4 -> {
                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter new age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new course: ");
                    String course = scanner.nextLine();
                    studentService.updateStudent(id, name, age, course);
                }
                case 5 -> {
                    System.out.print("Enter student ID to delete: ");
                    int id = scanner.nextInt();
                    studentService.deleteStudent(id);
                }
                case 6 -> {
                    exit = true;
                    System.out.println("👋 Exiting... Goodbye!");
                }
                default -> System.out.println("❌ Invalid choice. Try again.");
            }
        }

        scanner.close();
    }
}
