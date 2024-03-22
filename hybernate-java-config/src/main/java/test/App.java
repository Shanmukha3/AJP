package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		person p1 = new person(23, "Ravi", "VIGNAN", "8186906603");
		person p2 = new person(34, "Kishore", "VIGNAN", "9642759276");
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		session.persist(p2);

		tx.commit();

		factory.close();
		
//adding into ArrayList
		
//		Scanner sc=new Scanner(System.in);
//		System.out.println("Enter no of students ");
//		int no=sc.nextInt();
//		sc.nextLine();
//		ArrayList<person> obj=new ArrayList<>();
//		for (int i=0;i<no;i++)
//		{
//			System.out.println("Enter student details:");
//			System.out.println("ID: ");
//			int id=sc.nextInt();
//		    System.out.print("Name: ");
//		    String name = sc.next();
//		    sc.nextLine();
//		    System.out.print("address: ");
//		    String address = sc.next();
//		    sc.nextLine();
//		    System.out.print("Phone: ");
//		    String phone = sc.next();
//		    sc.nextLine();
//		    person p1 = new person(id, name, address, phone);
//		    obj.add(p1);
//		}
	}

}




//
//package com.vignan.hibernate.CRUD;
//
//import java.util.List;
//import java.util.Scanner;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//
//public class App {
//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//		while (true) {
//			System.out.println("Choose an option:");
//			System.out.println("1. Create");
//			System.out.println("2. Read");
//			System.out.println("3. Update");
//			System.out.println("4. Delete");
//			System.out.println("5. Exit");
//			int choice = scanner.nextInt();
//			scanner.nextLine(); // Consume the newline
//
//			switch (choice) {
//			case 1:
//				createStudent(sessionFactory, scanner);
//				break;
//			case 2:
//				readStudent(sessionFactory, scanner);
//				break;
//			case 3:
//				updateStudent(sessionFactory, scanner);
//				break;
//			case 4:
//				deleteStudent(sessionFactory, scanner);
//				break;
//			case 5:
//				sessionFactory.close();
//				System.out.println("Exiting...");
//				System.exit(0);
//				break;
//			default:
//				System.out.println("Invalid choice. Please select again.");
//			}
//		}	
//	}
//	private static void createStudent(SessionFactory sessionFactory, Scanner scanner) {
//		System.out.println("Enter student details:");
//	    System.out.print("Name: ");
//	    String name = scanner.nextLine();
//	    System.out.print("Branch: ");
//	    String branch = scanner.nextLine();
//	    System.out.print("Phone: ");
//	    String phone = scanner.nextLine();
//
//	    try (Session session = sessionFactory.openSession()) {
//	        session.beginTransaction();
//	        Student student = new Student();
//	        student.setName(name);
//	        student.setBranch(branch);
//	        student.setPhone(phone);
//	        session.persist(student);
//	        session.getTransaction().commit();
//	        System.out.println("Student created: " + student);
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
//    }
//	private static void readStudent(SessionFactory sessionFactory, Scanner scanner) {
//	    try (Session session = sessionFactory.openSession()) {
//	        session.beginTransaction();
//	        List<Student> students = session.createQuery("from Student", Student.class).getResultList();
//	        for (Student student : students) {
//	            System.out.println(student);
//	        }
//	        session.getTransaction().commit();
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
//	}
//
//	private static void updateStudent(SessionFactory sessionFactory, Scanner scanner) {
//	    System.out.print("Enter student id to update: ");
//	    int id = scanner.nextInt();
//	    scanner.nextLine(); // Consume the newline
//
//	    try (Session session = sessionFactory.openSession()) {
//	        session.beginTransaction();
//	        Student student = session.get(Student.class, id);
//
//	        if (student != null) {
//	            System.out.println("Current details: " + student);
//	            System.out.print("Enter new name: ");
//	            String newName = scanner.nextLine();
//	            System.out.print("Enter new branch: ");
//	            String newBranch = scanner.nextLine();
//	            System.out.print("Enter new phone: ");
//	            String newPhone = scanner.nextLine();
//
//	            student.setName(newName);
//	            student.setBranch(newBranch);
//	            student.setPhone(newPhone);
//
//	            session.getTransaction().commit();
//	            System.out.println("Student updated: " + student);
//	        } else {
//	            System.out.println("Student not found with id: " + id);
//	        }
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
//	}
//
//	private static void deleteStudent(SessionFactory sessionFactory, Scanner scanner) {
//	    System.out.print("Enter student id to delete: ");
//	    int id = scanner.nextInt();
//
//	    try (Session session = sessionFactory.openSession()) {
//	        session.beginTransaction();
//	        Student student = session.get(Student.class, id);
//
//	        if (student != null) {
//	            session.remove(student);
//	            session.getTransaction().commit();
//	            System.out.println("Student deleted: " + student);
//	        } else {
//	            System.out.println("Student not found with id: " + id);
//	        }
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
//	}
//}

    