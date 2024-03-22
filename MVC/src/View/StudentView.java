package View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Model.Student;

public class StudentView {
    private List<Student> studentList;
    private Scanner scanner;

    public StudentView() {
        this.studentList = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void addStudent() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        studentList.add(new Student(id, name, age));
    }

    public void updateStudent() {
        System.out.print("Enter ID to update: ");
        int updateId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new Name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter new Age: ");
        int newAge = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        for (Student student : studentList) {
            if (student.getId() == updateId) {
                student.setName(newName);
                student.setAge(newAge);
                break;
            }
        }
    }

    public void deleteStudent() {
        System.out.print("Enter ID to delete: ");
        int deleteId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        studentList.removeIf(student -> student.getId() == deleteId);
    }

    public void printStudentDetails() {
        for (Student student : studentList) {
            System.out.println("ID: " + student.getId());
            System.out.println("Name: " + student.getName());
            System.out.println("Age: " + student.getAge());
            System.out.println("--------------------");
        }
    }
}