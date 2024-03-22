package com.example;

import com.opensymphony.xwork2.ActionSupport;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.example.FactoryProvider;

import com.example.Task;




public class addTaskAction extends ActionSupport {

	static final long serialVersionUID = 1L;
	private Task task = new Task();

    public String post() {
        Session session = FactoryProvider.getFactory().openSession();
        Transaction tx = null;

        try {
        	
        	if (task.getTask_Name() == null || task.getTask_Name().isEmpty()) {
                addActionError("name cannot be null or empty.");
                return ERROR;
            }
            tx = session.beginTransaction();
            session.persist(task);
            tx.commit();
            addActionMessage("Content added successfully!");
            return SUCCESS;
        } catch (Exception e) {
            // Rollback the transaction in case of an exception
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            // Handle any exceptions that occur during the content addition process
            addActionError("Error adding content: " + e.getMessage());
            return ERROR;
        } finally {
            session.close();
        }
    }

    public Task getTask() {
        return task;
    }

    public void setContent(Task task) {
        this.task = task;
    }
}