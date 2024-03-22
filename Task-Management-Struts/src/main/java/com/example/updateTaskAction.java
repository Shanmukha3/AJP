package com.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;
import com.example.Task;

public class updateTaskAction extends ActionSupport {
	private int id;
	private Task task;

	public String post() {
		Session session = FactoryProvider.getFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			// Fetch the existing book from the database using ISBN
			Task existingTask = session.get(Task.class, id);

			if (existingTask  != null) {
				// Update the book details
				existingTask .setId(id);
				existingTask .setTask_Name(task.getTask_Name());
				existingTask .setDescription(task.getDescription());
				existingTask .setDueDate(task.getDueDate());
				existingTask .setPriority_Level(task.getPriority_Level());

				// Save the changes
				session.merge(existingTask );

				tx.commit();
				addActionMessage("Task updated successfully!");
				return SUCCESS;
			} else {
				addActionError("Task with Id " + id + " not found.");
				return ERROR;
			}
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			addActionError("Error updating task info: " + e.getMessage());
			return ERROR;
		} finally {
			session.close();
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

}
