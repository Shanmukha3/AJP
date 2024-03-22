package com.example;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.*;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "Task Name")
    private String Task_Name;

	@Column(name = "Description")
    private String Description;
    
    @Column(name = "DueDate")
    private Date DueDate;
    
    @Column(name = "Priority_Level")
    private String Priority_Level;
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTask_Name() {
		return Task_Name;
	}

	public void setTask_Name(String task_Name) {
		Task_Name = task_Name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Date getDueDate() {
		return DueDate;
	}

	public void setDueDate(Date dueDate) {
		DueDate = dueDate;
	}

	public String getPriority_Level() {
	    return Priority_Level;
	}

	public void setPriority_Level(String priority_Level) {
	    Priority_Level = priority_Level;
	}

	public Task(int id, String task_Name, String description, Date dueDate, String priority_Level) {
		super();
		this.id = id;
		Task_Name = task_Name;
		Description = description;
		DueDate = dueDate;
		Priority_Level = priority_Level;
	}

	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}

}