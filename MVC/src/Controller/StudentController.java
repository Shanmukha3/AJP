package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.Student;
import View.StudentView;

public class StudentController {
	private List<Student> studentList;
	private StudentView view;

	public StudentController(StudentView view) {
		this.studentList = new ArrayList<>();
		this.view = view;
	}

	public void addStudent(int id, String name, int age) {
		Student student = new Student(id, name, age);
		studentList.add(student);
	}

	public void updateStudent(int id, String name, int age) {
		for (Student student : studentList) {
			if (student.getId() == id) {
				student.setName(name);
				student.setAge(age);
				break;
			}
		}
	}

	public void deleteStudent(int id) {
		studentList.removeIf(student -> student.getId() == id);
	}

	public List<Student> getAllStudents() {
		return studentList;
	}
}