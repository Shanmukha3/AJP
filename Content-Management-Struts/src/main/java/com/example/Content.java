package com.example;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "contents")
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "Title")
    private String title;

	@Column(name = "Author")
    private String author;
    
    @Column(name = "PublishDate")
    private String publishDate;
    
    @Column(name = "Category")
    private String category;
    @Column(name = "Content")
    private String content;

    // Getters and setters

    public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // Constructors

    

    public Content() {
    }

	public Content(int id, String title, String author, String publishDate, String category, String content) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.publishDate = publishDate;
		this.category = category;
		this.content = content;
	}
}