/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.CartItemDAO;
import dal.CommentDAO;
import dal.ItemDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import model.CartItem;
import model.Comment;
import model.Item;
import model.User;

/**
 *
 * @author Fattt
 */
@WebServlet(name="ViewItemServlet", urlPatterns={"/viewItem"})
public class ViewItemServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ViewItemServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ViewItemServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String id = request.getParameter("id");
        ItemDAO idb = new ItemDAO();
        Item it = idb.getItemByID(id);
        CartItemDAO cidb = new CartItemDAO();
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("account");
        CartItem cit = cidb.getItemByUser(u, id);
        int inCart = 0;
        if(cit != null) inCart = cit.getQuantity();
        
        CommentDAO cmdb = new CommentDAO();
        ArrayList<Comment> listComment = cmdb.getCommentsByItem(it);
        if(!listComment.isEmpty()){
            for(Comment x : listComment){
                String newDate = formatDateDB(x.getDate());
                x.setDate(newDate);
            }
        }
        
        int ratingAverage = (int) Math.round(it.getRating());
        
        if(ratingAverage == 0) ratingAverage = 5;
        
        request.setAttribute("stars", ratingAverage);
        request.setAttribute("listComment", listComment);
        request.setAttribute("inCart", inCart);
        request.setAttribute("item", it);
        request.getRequestDispatcher("itemDetails.jsp").forward(request, response);
    } 
    
    private String formatDateDB(String dateString) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd MMMM yyyy", new Locale("en", "EN"));

        Date date = new Date();
        try {
            date = inputFormat.parse(dateString);
        } catch (ParseException ex) {
            System.out.println(ex);
        }
        String formattedDate = outputFormat.format(date);
        return formattedDate;
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
