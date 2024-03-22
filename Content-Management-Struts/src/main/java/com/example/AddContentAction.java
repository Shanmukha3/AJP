package com.example;

import com.opensymphony.xwork2.ActionSupport;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.example.FactoryProvider;

import com.example.Content;




public class AddContentAction extends ActionSupport {

	static final long serialVersionUID = 1L;
	private Content content = new Content();

    public String post() {
        Session session = FactoryProvider.getFactory().openSession();
        Transaction tx = null;

        try {
        	
        	if (content.getAuthor() == null || content.getAuthor().isEmpty()) {
                addActionError("Employee name cannot be null or empty.");
                return ERROR;
            }
            tx = session.beginTransaction();
            session.persist(content);
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

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }
}