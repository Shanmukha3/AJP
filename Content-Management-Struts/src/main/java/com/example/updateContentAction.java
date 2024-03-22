package com.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;
import com.example.Content;

public class updateContentAction extends ActionSupport {
	private int id;
	private Content content;

	public String post() {
		Session session = FactoryProvider.getFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			// Fetch the existing book from the database using ISBN
			Content existingContent = session.get(Content.class, id);

			if (existingContent != null) {
				// Update the book details
				existingContent.setId(id);
				existingContent.setTitle(content.getTitle());
				existingContent.setAuthor(content.getAuthor());
				existingContent.setContent(content.getContent());
				existingContent.setPublishDate(content.getPublishDate());
				existingContent.setCategory(content.getCategory());

				// Save the changes
				session.merge(existingContent);

				tx.commit();
				addActionMessage("Article updated successfully!");
				return SUCCESS;
			} else {
				addActionError("Article with Id " + id + " not found.");
				return ERROR;
			}
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			addActionError("Error updating Article info: " + e.getMessage());
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

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}

}
