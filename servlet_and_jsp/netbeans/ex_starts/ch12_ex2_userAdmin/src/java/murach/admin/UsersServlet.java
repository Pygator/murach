package murach.admin;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import murach.business.User;
import murach.data.UserDB;

public class UsersServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();

        String url = "/index.jsp";
        
        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "display_users";  // default action
        }
        
        // perform action and set URL to appropriate page
        if (action.equals("display_users")) {            
            // get list of users
            ArrayList<User> users = UserDB.selectUsers();            

            // set as a request attribute
            // forward to index.jsp
        } 
        else if (action.equals("display_user")) {
            // get user for specified email
            // set as session attribute
            // forward to user.jsp
        }
        else if (action.equals("update_user")) {
            // update user in database
            // get current user list and set as request attribute
            // forward to index.jsp
        }
        else if (action.equals("delete_user")) {
            // get the user for the specified email
            // delete the user            
            // get current list of users
            // set as request attribute
            // forward to index.jsp
        }
        
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }    
    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }    
}