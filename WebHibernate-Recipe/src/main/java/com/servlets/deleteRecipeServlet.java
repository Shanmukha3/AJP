
package com.servlets;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.helper.FactoryProvider;
import com.vignan.Recipe; // Make sure to import your Employee entity class

@WebServlet("/deleteRecipeServlet")
public class deleteRecipeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the ID of the employee to delete from the form
        int recipeId = Integer.parseInt(request.getParameter("recipeid"));

        // Create a Hibernate  Session
        Session session = FactoryProvider.getFactory().openSession();

        try {
            // Begin a transaction
            session.beginTransaction();

            // Retrieve the employee with the given ID from the database
            Recipe recipe = session.get(Recipe.class, recipeId);

            // Delete the employee if found
            if (recipe != null) {
                session.remove(recipe);
            } else {
            	response.setContentType("text/html");
        		PrintWriter out = response.getWriter();
            	out.println("<h1 style='text-align:center;'>Recipe Not Found</h1>");
        		out.println("<h1 style='text-align:center;'><a href='listRecipe.jsp'>View all Recipes</a></h1>");
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
