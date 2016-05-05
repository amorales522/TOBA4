/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.AccountDB;
import Database.TransactionDB;
import Database.UserDB;
import JavaBeans.Account;
import JavaBeans.Transaction;
import JavaBeans.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.PasswordUtil;

/**
 *
 * @author Morales
 */
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
        String userName = request.getParameter("user");
        String password = request.getParameter("pwd");
        
        UserDB userDb = new UserDB();
        AccountDB accountDb = new AccountDB();
        TransactionDB transactionDb = new TransactionDB();
        User user = userDb.check(userName, password);
        
        if(user != null)
        {
            Account checking = accountDb.getCheckingAccount(userName);
            Account saving = accountDb.getSavingAccount(userName);
  
            List<Transaction> list = new ArrayList<Transaction>();
            transactionDb.getTranction(saving.getId(),list);
            transactionDb.getTranction(checking.getId(),list);
            
            request.getSession().setAttribute("user", user);
            request.getSession().setAttribute("checking", checking);
            request.getSession().setAttribute("saving", saving);
            request.getSession().setAttribute("transactions", list);
            
            response.sendRedirect("Account_activity.jsp");
            return;
        }
        
        if(userName.equals("jsmith@toba.com") && password.equals("letmein"))
        {
            response.sendRedirect("Account_activity.jsp");
        }
        else
        {
            response.sendRedirect("Login_failure.jsp");
        }
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
