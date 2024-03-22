package com.vignan;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "recipes")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Recipeid")
    private int recipeid;

    @Column(name = "RecipeName")
    private String recipename;

    @Column(name = "Ingredients")
    private String ingredients;
    
    @Column(name = "Instructions")
    private String instructions;
    
    @Column(name = "DifficultyLevel")
    private String difficultylevel;

	public int getRecipeid() {
		return recipeid;
	}

	public void setRecipeid(int recipeid) {
		this.recipeid = recipeid;
	}

	public String getRecipename() {
		return recipename;
	}

	public void setRecipename(String recipename) {
		this.recipename = recipename;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public String getDifficultylevel() {
		return difficultylevel;
	}

	public void setDifficultylevel(String difficultylevel) {
		this.difficultylevel = difficultylevel;
	}

	public Recipe(int recipeid, String recipename, String ingredients, String instructions, String difficultylevel) {
		super();
		this.recipeid = recipeid;
		this.recipename = recipename;
		this.ingredients = ingredients;
		this.instructions = instructions;
		this.difficultylevel = difficultylevel;
	}

	public Recipe() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
