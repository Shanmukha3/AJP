package com.servlets;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;


import com.helper.FactoryProvider;
import com.vignan.Recipe; // Make sure to import your Employee entity class

@WebServlet("/updateRecipeServlet")
public class updateRecipeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve data from the form
        int recipeId = Integer.parseInt(request.getParameter("recipeid"));
        String recipeName = request.getParameter("recipeName");
		String ingredients = request.getParameter("ingredients");
		String instructions = request.getParameter("instructions");
		String difficultyLevel = request.getParameter("difficultyLevel");

        Session session = FactoryProvider.getFactory().openSession();

        try {
            // Begin a transaction
            session.beginTransaction();

            // Retrieve the employee with the given ID from the database
            Recipe recipe = session.get(Recipe.class, recipeId);

            // Update the employee's information
            if (recipe != null) {
            	recipe.setRecipename(recipeName);
        		recipe.setIngredients(ingredients);
        		recipe.setInstructions(instructions);
        		recipe.setDifficultylevel(difficultyLevel);

                // Save the updated employee to the database
                session.merge(recipe);
            } else {
            	response.setContentType("text/html");
        		PrintWriter out = response.getWriter();
            	out.println("<h1 style='text-align:center;'>Recipe Not Found</h1>");
        		out.println("<h1 style='text-align:center;'><a href='listRecipes.jsp'>View all Recipe</a></h1>");
            }

            // Commit the transaction
            session.getTransaction().commit();
        } finally {
            session.close();
        }

        // Redirect to a success page or a list of employees
        response.sendRedirect("listRecipe.jsp");
    }
}
