package main;
import java.util.Scanner;
import View.StudentView;
public class MVCDemo {
	public static void main(String[] args) {
        StudentView view = new StudentView();
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. View All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    view.addStudent();
                    break;
                case 2:
                    view.updateStudent();
                    break;
                case 3:
                    view.deleteStudent();
                    break;
                case 4:
                    view.printStudentDetails();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }
}