/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.AccountDB;
import Database.TransactionDB;
import JavaBeans.Account;
import JavaBeans.Transaction;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Morales
 */
public class TransactionServlet extends HttpServlet {

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
         DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
           Date date = new Date();
        try {
           String account = request.getParameter("account");
           String transaction = request.getParameter("transaction");
           int balance = Integer.parseInt(request.getParameter("balance"));
           AccountDB accountDb = new AccountDB();
        TransactionDB transactionDb = new TransactionDB();
           
           if(account.equals("saving"))
           {
               Account saving =(Account) request.getSession().getAttribute("saving");
               if(transaction.equals("Credit"))
               {
                   saving.credit(balance);
                   saving.setAccountType(Account.AccountType.Savings);
                   accountDb.UpdateAccount(saving);
                   Transaction tran = new Transaction (saving.getId(),balance,"credit");
                   tran.setTime(dateFormat.format(date));
                   transactionDb.insertTranction(tran,"Credit");
               }
               if(transaction.equals("Debit"))
               {
                   
                   saving.debit(balance);
                   saving.setAccountType(Account.AccountType.Savings);
                   accountDb.UpdateAccount(saving);
                   Transaction tran = new Transaction (saving.getId(),balance,"Debit");
                   tran.setTime(dateFormat.format(date));
                   transactionDb.insertTranction(tran,"Debit");
                   
               }
           }
           if(account.equals("checking"))
           {
               Account checking =(Account) request.getSession().getAttribute("checking");
               if(transaction.equals("Credit"))
               {
                   checking.credit(balance);
                   checking.setAccountType(Account.AccountType.Checking);
                   accountDb.UpdateAccount(checking);
                   Transaction tran = new Transaction (checking.getId(),balance,"credit");
                   tran.setTime(dateFormat.format(date));
                   transactionDb.insertTranction(tran,"Credit");
               }
               if(transaction.equals("Debit"))
               {
                   
                   checking.debit(balance);
                   checking.setAccountType(Account.AccountType.Checking);
                   accountDb.UpdateAccount(checking);
                   Transaction tran = new Transaction (checking.getId(),balance,"Debit");
                   tran.setTime(dateFormat.format(date));
                   transactionDb.insertTranction(tran,"Debit");
                   
               }
           }
            response.sendRedirect("Transaction.jsp");
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
