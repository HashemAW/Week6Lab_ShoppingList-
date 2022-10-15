/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        if (request.getParameter("action") == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;

        } else if (request.getParameter("action").equals("logout")) {
            String loggedOut = "You have successfully logged out";
            request.setAttribute("message", loggedOut);

            session.invalidate();

            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;

        }

         //create an arraylist to hold the shopping list items
        ArrayList<String> myItems = (ArrayList<String>) session.getAttribute("myList");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        
        ArrayList<String> list = (ArrayList<String>) session.getAttribute("list");;
        
        if(list == null){
           list = new ArrayList<>();
           System.out.println("We created a new list");
        }

        if (request.getParameter("action").equals("register")) {

            if (request.getParameter("username") == null || request.getParameter("username").equals("")) {
                String error = "Please enter username";
                request.setAttribute("message", error);
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);

                return;
            } else {
                String username = request.getParameter("username");
                session.setAttribute("username", username);
            }
        }

        if (request.getParameter("action").equals("add")) {
            String item = request.getParameter("item");
            
            if(item == null || item.equals("")){
                
            String errormessage = "Please enter item";
            request.setAttribute("errormessage", errormessage);
            
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;
            
            } else {
                list.add(item);
                session.setAttribute("list", list);
            }    
        }
 
        
        if (request.getParameter("action").equals("delete")) {
            
            String selectedItem = request.getParameter("listItem");
            
            if(selectedItem == null || selectedItem.equals("")){
             String errormessage = "Please select an item to delete";
            request.setAttribute("errormessage", errormessage);
            } else {
                list.remove(selectedItem);
            }
            
        }
        

        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
    }
}