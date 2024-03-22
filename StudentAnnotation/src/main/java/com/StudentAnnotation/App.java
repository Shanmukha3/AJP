package com.StudentAnnotation;

import java.util.Scanner;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class App {
	private static int d;

	public static void main(String[]  args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			System.out.println("1.create student");
			System.out.println("2.delete record");
			System.out.println("3.Update name");
			System.out.println("4.Get information");
			System.out.println("5.Get all info");
			System.out.println("6.Exit");
			
			System.out.println("Enter your choice");
			int option=sc.nextInt();
			switch (option)
			{
			case 1:
				System.out.println("Enter Roll no");
				int roll=sc.nextInt();
				sc.nextLine();
				System.out.println("Enter First name");
				String first=sc.next();
				sc.nextLine();
				System.out.println("Enter Last Name");
				String last=sc.next();
				sc.nextLine();
				Session session = factory.openSession();
				Transaction tx = session.beginTransaction();
				Student e1 = new Student();
				e1.setId(roll);
				e1.setFirstnname(first);
				e1.setLastname(last);
				session.persist(e1);
				tx.commit();
				System.out.println("Sucessfull inserted....");
				tx.commit();
				session.close();
				break;
			case 2:
				System.out.println("Enter roll number you want to delete");
				d = sc.nextInt();
				Session session1 = factory.openSession();
				Transaction tx1 = session1.beginTransaction();
				Student stu=session1.get(Student.class,d);
				if (stu!=null)
				{
					session1.remove(stu);
					session1.getTransaction().commit();
					System.out.println("Sucessfully removed");
				}
				else {
					System.out.println("No such data is present ");
				}
				tx1.commit();
				session1.close();
				break;
			case 3:
				System.out.print("Enter student id to update: ");
			    int d = sc.nextInt();
			    sc.nextLine();
			    Session session2 = factory.openSession();
				Transaction tx2 = session2.beginTransaction();
				Student st=session2.get(Student.class,d);
				if (st!=null)
				{
					System.out.println("Enter new firstname");
					String newfirstname=sc.next();
					sc.nextLine();
					System.out.println("Enter new lastName");
					String newlastname=sc.next();
					sc.nextLine();
					st.setFirstnname(newfirstname);
					st.setLastname(newlastname);
					session2.getTransaction().commit();
					System.out.println("Sucessfully updated");
				}
				else {
					System.out.println("Student not found with id: " + d);
				}
				tx2.commit();
				session2.close();
				break;
			case 4:
				System.out.println("enter number to get info");
				int number=sc.nextInt();
				sc.nextLine();
				Session session3 = factory.openSession();
				Transaction tx3 = session3.beginTransaction();
				Student student=session3.get(Student.class,number);
				if(student!=null) {
					System.out.println(student);
					session3.getTransaction().commit();
				}
				else {
					System.out.println("No data exist");
				}
				tx3.commit();
				session3.close();
				break;
			case 5:
				Session session4 = factory.openSession();
				Transaction tx4 = session4.beginTransaction();
				List<Student> students = session4.createQuery("from Student", Student.class).getResultList();
				for (Student stud : students) {
				    System.out.println(stud);
				}
				tx4.commit();
				session4.close();

			case 6:
				factory.close();
				System.out.println("Exiting........!");
				System.exit(0);
			}
		}
	}

}