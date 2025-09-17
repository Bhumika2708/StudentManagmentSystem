package service;

import dao.StudentDAO;
import dao.StudentDAOImpl;
import model.Student;

import java.util.List;

public class StudentService {
    private final StudentDAO dao = new StudentDAOImpl();

    public void addStudent(String name, int age, String course) {
        if (name == null || name.isEmpty() || course == null || course.isEmpty() || age <= 0) {
            System.out.println("❌ Invalid student data.");
            return;
        }
        Student student = new Student(0, name, age, course); // ID auto-generated
        dao.addStudent(student);
        System.out.println("✅ Student added successfully.");
    }

    public void updateStudent(int id, String name, int age, String course) {
        Student student = dao.getStudentById(id);
        if (student == null) {
            System.out.println("❌ Student not found with ID: " + id);
            return;
        }
        student.setName(name);
        student.setAge(age);
        student.setCourse(course);
        dao.updateStudent(student);
        System.out.println("✅ Student updated successfully.");
    }

       public void deleteStudent(int id) {
        Student student = dao.getStudentById(id);
        if (student == null) {
            System.out.println("❌ Student not found.");
            return;
        }
        dao.deleteStudent(id);
        System.out.println("✅ Student deleted successfully.");
    }



            public void viewAllStudents() {
        List<Student> list = dao.getAllStudents();
        if (list.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student s : list) {
                System.out.println(s);
            }
        }
    }

    public void viewStudent(int id) {
        Student student = dao.getStudentById(id);
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("❌ Student not found.");
        }
    }}
