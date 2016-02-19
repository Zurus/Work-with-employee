/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Артур
 */
@WebServlet(name = "Users", urlPatterns = {"/Users"})
public class Users extends HttpServlet {
    
    private void actionLogIn(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String lg = "Admin", pas = "Admin"; 
        try {
            String login = request.getParameter("Login");
            String password = request.getParameter("Password");
            if((lg.equals(login))&&(pas.equals(password))){
                Cookie valueOfLogin = new Cookie("Login", login);
                valueOfLogin.setMaxAge(100500);
                response.addCookie(valueOfLogin);
                response.sendRedirect("/servlet/views/employees/index.jsp");
            }else{
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Users</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Incorrect Login</h1>");
            out.println("</body>");
            out.println("</html>");
            }
        } finally {            
            out.close();
        }
    }
    private void actionLogOut(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        Cookie[] arrOfCookie = request.getCookies();
        for(Cookie value: arrOfCookie){
            if(value.getName().equals("Login")){
                value.setMaxAge(0);
                response.addCookie(value);
            }
        }
        response.sendRedirect("/servlet/index.jsp");
    }
    
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String param = request.getParameter("action");
       if("login".equals(param)){
           actionLogIn(request, response);
       } else if("logout".equals(param)){
           actionLogOut(request, response);
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}   
