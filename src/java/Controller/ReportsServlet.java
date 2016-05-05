/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.UserDB;
import JavaBeans.User;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


/**
 *
 * @author Morales
 */
@WebServlet(name = "ReportsServlet", urlPatterns = {"/ReportsServlet"})
public class ReportsServlet extends HttpServlet {

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
        
        String reqStr = request.getParameter("Submit");
        UserDB userdb = new UserDB();
        ArrayList<User> list = userdb.getUsers();
        if(list == null)
        {
             list = new  ArrayList<User>();
        }
        
        
        if(reqStr.equals("Show Reports"))
        {
            request.getSession().setAttribute("Users", list);
            response.sendRedirect("admin/reports.jsp");
            System.out.println("IN the Reports");
            return;
        }
        if(reqStr.equals("Get SpreadSheet"))
        {
             Workbook workbook = new HSSFWorkbook();
             Sheet sheet = workbook.createSheet("User Table");
             Row row = sheet.createRow(0);
             row.createCell(0).setCellValue("The User table");
             int i=2;
             
             for (int j = 0 ; j<list.size() ; j++)
             {
                 row = sheet.createRow(i);
                 row.createCell(0).setCellValue(list.get(j).getId());
                 row.createCell(1).setCellValue(list.get(j).getFirstName());
                 row.createCell(2).setCellValue(list.get(j).getLastName());
                 row.createCell(3).setCellValue(list.get(j).getUsername());
                 row.createCell(4).setCellValue(list.get(j).getAddress());
                 row.createCell(5).setCellValue(list.get(j).getPhoneNumber());
                 row.createCell(6).setCellValue(list.get(j).getCity());
                 row.createCell(7).setCellValue(list.get(j).getState());
                 row.createCell(8).setCellValue(list.get(j).getEmail());
                 row.createCell(9).setCellValue(list.get(j).getZipCode());
                 i++;
             }
             response.setContentType("application/vnd.ms-excel");
     response.setHeader("Content-Disposition","attachment; filename=users.xls");
     response.setHeader("cache-control", "no-cache");
           response.sendRedirect("admin/reports.jsp");
            System.out.println("IN the Reports");
//            String filePath ="c:\\excel\\dbreport.xls"; 
//
//
//response.setHeader("Content-Disposition", "attachment; filename=\"dbreport.xls\" "); 
//
//FileOutputStream fileOut = new FileOutputStream(filePath); 
//workbook.write(fileOut); 
//fileOut.close(); 
//out.close(); 
//            return;  
             
        }
        
        
        try {
           
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
        Workbook workbook = new HSSFWorkbook();
        
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
